/*
 * Project: MyApplication
 * File: SplashScreenViewProvider
 *
 * Created by: charvin on 9/1/24.
 * Last modified by: charvin on 9/1/24.
 *
 * Description:
 * 
 */

package com.example.myapp.feature.splash_screen

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

class SplashScreenViewProvider(private val activity: Activity) {

    val view: ViewGroup by lazy {
        FrameLayout.inflate(activity, R.layout.splash_screen_view, null) as ViewGroup
    }

    val iconView: View get() = view.findViewById(R.id.splashscreen_icon_view)

    val iconAnimationStartMillis: Long = 0

    val iconAnimationDurationMillis: Long = 0

    init {
        attachToActivity()
    }

    fun remove() {
        (view.parent as? ViewGroup)?.removeView(view)
    }

    private fun attachToActivity() {
        val content = activity.findViewById<ViewGroup>(android.R.id.content)
        (content.rootView as? ViewGroup)?.addView(view)
    }
}

