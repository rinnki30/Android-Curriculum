package com.example.androidcurriculum.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidcurriculum.R
import com.example.androidcurriculum.data.model.Item

class ArticleAdapter(var articles: List<Item>) :
    RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageView)
        val title: TextView = itemView.findViewById(R.id.titleTextView)
        val author: TextView = itemView.findViewById(R.id.authorTextView)
        val content: TextView = itemView.findViewById(R.id.contentTextView)
        val likes: Button = itemView.findViewById(R.id.likeButton)
        val comment: Button = itemView.findViewById(R.id.commentButton)
        val favorite: Button = itemView.findViewById(R.id.favoriteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.title.text = article.title
        holder.author.text = article.author
        holder.content.text = article.content

        Glide.with(holder.itemView.context)
            .load("http:/192.168.31.246:8080" + article.imageUrl)
            .into(holder.image)

    }

    override fun getItemCount() = articles.size

    fun updateArticles(newArticles: List<Item>) {
        articles = newArticles
        notifyDataSetChanged()
    }
}