package com.example.androidcurriculum.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidcurriculum.data.ArticleRepository
import com.example.androidcurriculum.data.model.Article

class ArticleViewModel(private val articleRepository: ArticleRepository) : ViewModel() {

    private val _article = MutableLiveData<Article>()
    val article: LiveData<Article> = _article
//
//    fun loadArticle(articleId: Int) {
//        val article = repository.getArticle(articleId)
//        _article.postValue(article)
//    }
//
//    fun updateArticleLikes(articleId: Int, newLikes: Int) {
//        repository.updateArticleLikes(articleId, newLikes)
//        loadArticle(articleId)
//    }
//
//    fun updateArticleComments(articleId: Int, newComments: Int) {
//        repository.updateArticleComments(articleId, newComments)
//        loadArticle(articleId)
//    }
//
//    fun updateArticleFavorites(articleId: Int, newFavorites: Int) {
//        repository.updateArticleFavorites(articleId, newFavorites)
//        loadArticle(articleId)
//    }

    //    private fun fetchArticles() {
//        val call = RetrofitInstance.api.getArticles()
//        call.enqueue(object : Callback<List<Article>> {
//
//            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onResponse(call: Call<List<Article>>, response: Response<List<Article>>) {
//                val articleResponse = response.body()
//                ArticleAdapter = ArticleAdapter(articleResponse.data)
//                recyclerView.adapter = ArticleAdapter
//            }
//        })
//    }
//    fun fetchArticles() {
//        articleRepository.fetchArticles()
//    }
//    private fun fetchArticles() {
//        val call = RetrofitInstance.api.getArticles()
//        call.enqueue(object : Callback<Article> {
//            override fun onResponse(call: Call<Article>, response: Response<Article>) {
//                val articleResponse = response.body()
//                if (articleResponse != null) {
//                    val ArticleAdapter = ArticleAdapter(articleResponse.data)
//                    recyclerView.adapter = ArticleAdapter
//                }
//
//            }
//
//            override fun onFailure(call: Call<Article>, t: Throwable) {
//            }
//        })
//    }
//}
}