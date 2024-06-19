package com.example.androidcurriculum.data

import androidx.recyclerview.widget.RecyclerView
import com.example.androidcurriculum.Adapter.ArticleAdapter

class ArticleDataSource {
    private lateinit var articleAdapter: ArticleAdapter
    private lateinit var recyclerView: RecyclerView
//    private val dbHelper = MyDatabaseHelper(MyApplication.context, "Article.db", 1)

    //    fun getArticles(): List<Article> {
//        val db = dbHelper.readableDatabase
//        val cursor = db.query(
//            "Article",
//            arrayOf(
//                "id",
//                "title",
//                "content",
//                "imageUrl",
//                "author",
//                "likes",
//                "comments",
//                "favorites"
//            ),
//            null,
//            null,
//            null,
//            null,
//            null
//        )
//        val articles = mutableListOf<Article>()
//        with(cursor) {
//            while (moveToNext()) {
//                val id = getInt(getColumnIndexOrThrow("id"))
//                val title = getString(getColumnIndexOrThrow("title"))
//                val content = getString(getColumnIndexOrThrow("content"))
//                val imageUrl = getString(getColumnIndexOrThrow("imageUrl"))
//                val author = getString(getColumnIndexOrThrow("author"))
//                val likes = getInt(getColumnIndexOrThrow("likes"))
//                val comments = getInt(getColumnIndexOrThrow("comments"))
//                val favorites = getInt(getColumnIndexOrThrow("favorites"))
//                articles.add(
//                    Article(
//                        id,
//                        title,
//                        content,
//                        imageUrl,
//                        author,
//                        likes,
//                        comments,
//                        favorites
//                    )
//                )
//            }
//        }
//        cursor.close()
//        db.close()
//        return articles
//    }
//    //这是一个用来获取文章的方法
//    fun getArticle(id: Int): Article? {
//        val db = dbHelper.readableDatabase
//        val cursor = db.query(
//            "articles", null, "id = ?", arrayOf(id.toString()),
//            null, null, null
//        )
//
//        var article: Article? = null
//        if (cursor.moveToFirst()) {
//            article = cursorToArticle(cursor)
//        }
//        cursor.close()
//        db.close()
//        return article
//    }
//
//    private fun cursorToArticle(cursor: Cursor): Article {
//        return Article(
//            id = cursor.getInt(cursor.getColumnIndexOrThrow("id")),
//            title = cursor.getString(cursor.getColumnIndexOrThrow("title")),
//            content = cursor.getString(cursor.getColumnIndexOrThrow("content")),
//            imagesUrl = cursor.getString(cursor.getColumnIndexOrThrow("image_url")),
//            likes = cursor.getInt(cursor.getColumnIndexOrThrow("likes")),
//            author = cursor.getString(cursor.getColumnIndexOrThrow("author")),
//            comments = cursor.getInt(cursor.getColumnIndexOrThrow("comments")),
//            favorites = cursor.getInt(cursor.getColumnIndexOrThrow("favorites"))
//        )
//    }

//    fun updateArticleLikes(articleId: Int, newLikes: Int) {
//        val db = dbHelper.writableDatabase
//        val values = ContentValues().apply {
//            put("likes", newLikes)
//        }
//        db.update("articles", values, "id = ?", arrayOf(articleId.toString()))
//        getArticle(articleId)
//    }
//
//    fun updateArticleComments(articleId: Int, newComments: Int) {
//        val db = dbHelper.writableDatabase
//        val values = ContentValues().apply {
//            put("comments", newComments)
//        }
//        db.update("articles", values, "id = ?", arrayOf(articleId.toString()))
//        getArticle(articleId)
//    }
//
//    fun updateArticleFavorites(articleId: Int, newFavorites: Int) {
//        val db = dbHelper.writableDatabase
//        val values = ContentValues().apply {
//            put("favorites", newFavorites)
//        }
//        db.update("articles", values, "id = ?", arrayOf(articleId.toString()))
//        getArticle(articleId)
//    }


}