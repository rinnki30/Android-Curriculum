package com.example.androidcurriculum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegister = findViewById<TextView>(R.id.tvRegister)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            // 这里可以添加实际的登录逻辑，例如验证用户名和密码
            if (username == "admin" && password == "admin") {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                // 登录成功后跳转到其他页面
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }

        tvRegister.setOnClickListener {
            // 跳转到注册页面
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}