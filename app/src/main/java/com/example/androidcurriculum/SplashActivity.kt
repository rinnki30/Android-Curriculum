package com.example.androidcurriculum

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AlphaAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val SPLASH_DISPLAY_LENGTH = 3000 // 延迟时间（毫秒）

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashImage = findViewById<ImageView>(R.id.splashImage)

        // 设置淡入动画
        val fadeIn = AlphaAnimation(0.0f, 1.0f)// 从完全透明到完全不透明
        fadeIn.duration = 1500 // 动画持续时间
        splashImage.startAnimation(fadeIn)// 开始动画

        Handler(Looper.getMainLooper()).postDelayed({
            // 动画结束后跳转到主活动
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}
