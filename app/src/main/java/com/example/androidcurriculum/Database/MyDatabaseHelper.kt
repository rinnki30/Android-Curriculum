package com.example.androidcurriculum.Database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDatabaseHelper(val context: Context, name: String, version: Int) :
    SQLiteOpenHelper(context, name, null, version) {
    private val createLogin =
        //创建Login表
        "create table Login (" +
                "id integer primary key autoincrement, " +
                "username text, " +
                "password text )"

    private val createArticles =
        //创建Articles表
        "create table Articles (" +
                "id integer primary key autoincrement," +
                "title TEXT NOT NULL," +
                "content TEXT NOT NULL," +
                "author TEXT NOT NULL," +
                "image_url TEXT NOT NULL," +
                "likes INTEGER DEFAULT 0," +
                "comments INTEGER DEFAULT 0," +
                "favorites INTEGER DEFAULT 0)"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(createLogin)
        db.execSQL(createArticles)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }
}