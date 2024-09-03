package com.example.myapp.feature.splash_screen

import android.app.Activity
import androidx.annotation.MainThread

class SplashScreen private constructor(private val activity: Activity) {

    private val impl = SplashScreenImpl(activity)

    companion object {
        private const val MASK_FACTOR = 2 / 3f

        @JvmStatic
        fun Activity.installSplashScreen(): SplashScreen {
            return SplashScreen(this).apply { install() }
        }
    }

    fun setKeepOnScreenCondition(condition: KeepOnScreenCondition) {
        impl.setKeepOnScreenCondition(condition)
    }

    @SuppressWarnings("ExecutorRegistration") // Always runs on the MainThread
    fun setOnExitAnimationListener(listener: OnExitAnimationListener) {
        impl.setOnExitAnimationListener(listener)
    }

    private fun install() {
        impl.install()
    }

    fun interface OnExitAnimationListener {
        @MainThread
        fun onSplashScreenExit(splashScreenViewProvider: SplashScreenViewProvider)
    }

    fun interface KeepOnScreenCondition {
        @MainThread
        fun shouldKeepOnScreen(): Boolean
    }
}
