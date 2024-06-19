package com.example.androidcurriculum.data.model

//
data class Article(
    val data: List<Item>
)

data class Item(
    val id: Int,
    val imageUrl: String,
    val title: String,
    val content: String,
    val author: String,
    var likes: Int,
    var comments: Int,
    var favorites: Int
)