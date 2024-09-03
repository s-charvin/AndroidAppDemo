/*
 * Project: MyApplication
 * File: SplashScreenImpl
 *
 * Created by: charvin on 9/1/24.
 * Last modified by: charvin on 9/1/24.
 *
 * Description:
 * 
 */

package com.example.myapp.feature.splash_screen


import android.app.Activity
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.View
import android.view.ViewTreeObserver.OnPreDrawListener
import android.widget.ImageView

internal class SplashScreenImpl(private val activity: Activity) {

    private var finalThemeId: Int = 0
    private var backgroundResId: Int? = null
    private var backgroundColor: Int? = null
    private var icon: Drawable? = null
    private var splashScreenWaitJudgment: SplashScreen.KeepOnScreenCondition = SplashScreen.KeepOnScreenCondition { false }
    private var animationListener: SplashScreen.OnExitAnimationListener? = null
    private var mSplashScreenViewProvider: SplashScreenViewProvider? = null

    fun install() {
        val typedValue = TypedValue()
        val currentTheme = activity.theme

        backgroundResId = currentTheme.resolveAttributeOrNull(R.attr.windowSplashScreenBackground, typedValue)
        backgroundColor = typedValue.data.takeIf { backgroundResId != null }

        icon = currentTheme.resolveAttributeOrNull(R.attr.windowSplashScreenIcon, typedValue)?.let {
            currentTheme.getDrawable(it)
        }

        setPostSplashScreenTheme(currentTheme, typedValue)
    }


    fun setKeepOnScreenCondition(condition: SplashScreen.KeepOnScreenCondition) {
        splashScreenWaitJudgment = condition
        val contentView = activity.findViewById<View>(android.R.id.content)


        // 通过视图树观察者监听视图树的绘制事件, 当视图树准备绘制时, 判断是否还需要保持在启动屏幕上
        contentView.viewTreeObserver.addOnPreDrawListener(object : OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                if (splashScreenWaitJudgment.shouldKeepOnScreen()) {
                    return false
                }
                // 当不需要保持在启动屏幕上时, 移除视图树观察者, 并执行退出动画
                contentView.viewTreeObserver.removeOnPreDrawListener(this)
                mSplashScreenViewProvider?.let { dispatchOnExitAnimation(it) }
                return true
            }
        })
    }

    /**
     * 获取 postSplashScreenTheme 属性的值, 并设置为 activity 的主题
     * 用户可以通过设置 postSplashScreenTheme 属性来改变父 activity 的主题
     *
     * @param currentTheme 当前 activity 的主题
     * @param typedValue 用于存储属性值的 TypedValue
     * @return 无返回值
     *
     */
    private fun setPostSplashScreenTheme(currentTheme: Resources.Theme, typedValue: TypedValue) {
        if (currentTheme.resolveAttribute(R.attr.postSplashScreenTheme, typedValue, true)) {
            finalThemeId = typedValue.resourceId
            if (finalThemeId != 0) {
                activity.setTheme(finalThemeId)
            }
        }
    }

    fun setOnExitAnimationListener(listener: SplashScreen.OnExitAnimationListener) {
        animationListener = listener
        SplashScreenViewProvider(activity).apply {
            val finalBackgroundResId = backgroundResId
            val finalBackgroundColor = backgroundColor
            val splashScreenView = view
            val splashIcon = icon

            if (finalBackgroundResId != null && finalBackgroundResId != Resources.ID_NULL) {
                splashScreenView.setBackgroundResource(finalBackgroundResId)
            } else if (finalBackgroundColor != null) {
                splashScreenView.setBackgroundColor(finalBackgroundColor)
            } else {
                splashScreenView.background = activity.window.decorView.background
            }

            splashIcon?.let { it ->
                splashScreenView.findViewById<ImageView>(R.id.splashscreen_icon_view).apply {
                    setImageDrawable(it)
                }
            }

            splashScreenView.addOnLayoutChangeListener(
                object : View.OnLayoutChangeListener {
                    override fun onLayoutChange(
                        view: View,
                        left: Int,
                        top: Int,
                        right: Int,
                        bottom: Int,
                        oldLeft: Int,
                        oldTop: Int,
                        oldRight: Int,
                        oldBottom: Int
                    ) {
                        if (!view.isAttachedToWindow) return

                        view.removeOnLayoutChangeListener(this)
                        if (!splashScreenWaitJudgment.shouldKeepOnScreen()) {
                            dispatchOnExitAnimation(this@apply)
                        } else {
                            mSplashScreenViewProvider = this@apply
                        }
                    }
                }
            )
        }
    }

    private fun dispatchOnExitAnimation(provider: SplashScreenViewProvider) {
        animationListener?.let { listener ->
            animationListener = null
            provider.view.postOnAnimation {
                provider.view.bringToFront()
                listener.onSplashScreenExit(provider)
            }
        }
    }

    private fun Resources.Theme.resolveAttributeOrNull(attr: Int, typedValue: TypedValue): Int? {
        return if (resolveAttribute(attr, typedValue, true)) typedValue.resourceId else null
    }
}
