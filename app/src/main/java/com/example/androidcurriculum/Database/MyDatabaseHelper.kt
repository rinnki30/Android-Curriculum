package com.example.androidcurriculum.Database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabaseHelper(val context: Context, name: String, version: Int) :
    SQLiteOpenHelper(context, name, null, version) {
    private val createLogin = "create table Login (" +
            "id integer primary key autoincrement, " +
            "username text, " +
            "password text )" // 创建登录表

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(createLogin)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }
}