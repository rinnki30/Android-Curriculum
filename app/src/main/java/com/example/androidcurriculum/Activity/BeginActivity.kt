package com.example.androidcurriculum.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidcurriculum.R

class BeginActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_begin)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val ReisterButton: Button = findViewById(R.id.RegisterButton)
        val LoginButton: Button = findViewById(R.id.LoginButton)

        ReisterButton.setOnClickListener {
            // 跳转到注册页面
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        LoginButton.setOnClickListener {
            // 跳转到登录页面
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }
    }
}