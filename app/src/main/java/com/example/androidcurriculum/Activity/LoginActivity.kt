package com.example.androidcurriculum.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidcurriculum.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

    }
}
