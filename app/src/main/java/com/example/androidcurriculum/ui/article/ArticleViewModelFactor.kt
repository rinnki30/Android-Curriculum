package com.example.androidcurriculum.ui.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidcurriculum.data.ArticleDataSource
import com.example.androidcurriculum.data.ArticleRepository

class ArticleViewModelFactory :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArticleViewModel::class.java)) {
            return ArticleViewModel(
                articleRepository = ArticleRepository(
                    dataSource = ArticleDataSource()
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}