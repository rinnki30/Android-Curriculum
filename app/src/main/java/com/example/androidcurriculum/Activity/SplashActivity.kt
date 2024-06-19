package com.example.androidcurriculum.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AlphaAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidcurriculum.R

//开始界面
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
            val beginIntent = Intent(this, BeginActivity::class.java)
            startActivity(beginIntent)
            finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}
