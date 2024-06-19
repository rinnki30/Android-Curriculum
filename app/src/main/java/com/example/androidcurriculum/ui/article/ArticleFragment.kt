package com.example.androidcurriculum.ui.article

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcurriculum.Adapter.ArticleAdapter
import com.example.androidcurriculum.MyApplication
import com.example.androidcurriculum.R
import com.example.androidcurriculum.RetrofitInstance
import com.example.androidcurriculum.data.model.Article
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ArticleFragment : Fragment() {

    private lateinit var articleViewModel: ArticleViewModel
    private lateinit var articleAdapter: ArticleAdapter
    private lateinit var recyclerView: RecyclerView

    private fun fetchArticles() {
        val call = RetrofitInstance.api.getArticles()

//    lateinit var ArticleAdapter: ArticleAdapter
//    var ArticleAdapter: ArticleAdapter
        call.enqueue(object : Callback<Article> {
            override fun onResponse(call: Call<Article>, response: Response<Article>) {
                val articleResponse = response.body()
                if (articleResponse != null) {
//                articleAdapter = articleAdapter(articleResponse.data)
//                recyclerView.adapter = ArticleAdapter

                    articleAdapter.updateArticles(articleResponse.data)
                } else {
                    Log.e("ArticleFragment", "Response body is null")
                }

            }

            override fun onFailure(call: Call<Article>, t: Throwable) {
                Log.e("ArticleFragment", "API call failed", t)
            }
        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_article, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        articleViewModel = ViewModelProvider(
            this,
            ArticleViewModelFactory()
        ).get(ArticleViewModel::class.java)

        recyclerView = view.findViewById(R.id.recycler_view)

        val layoutManager = LinearLayoutManager(MyApplication.context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = layoutManager

        articleAdapter = ArticleAdapter(emptyList())
        recyclerView.adapter = articleAdapter

        fetchArticles()

    }
}


//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)

//        articleViewModel = ViewModelProvider(this).get(ArticleViewModel::class.java)
//        articleAdapter = ArticleAdapter(emptyList()) { article ->
//            // Handle item click
//        }
//
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//        recyclerView.adapter = articleAdapter
//
//        articleViewModel.articleList.observe(viewLifecycleOwner, Observer { articles ->
//            articleAdapter = ArticleAdapter(articles) { article ->
//                // Handle item click
//            }
//            recyclerView.adapter = articleAdapter
//        })
//
//        articleViewModel.loadArticles() // Ensure this method loads the articles from the database
//    }
//}

