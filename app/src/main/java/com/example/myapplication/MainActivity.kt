package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        val greetingText = "Hello Android!"
        setContentView(android.widget.TextView(this).apply {
            text = greetingText
            textSize = 24f
            gravity = android.view.Gravity.CENTER
        })
    }

    private fun enableEdgeToEdge() {
        // 设置边到边
        window.decorView.systemUiVisibility = (
                window.decorView.systemUiVisibility
                        or android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or android.view.View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                )
        window.statusBarColor = android.graphics.Color.TRANSPARENT
        window.navigationBarColor = android.graphics.Color.TRANSPARENT
    }
}
