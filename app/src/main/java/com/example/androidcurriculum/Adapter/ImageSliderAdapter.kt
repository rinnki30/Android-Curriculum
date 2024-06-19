package com.example.androidcurriculum.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidcurriculum.R

class ImageSliderAdapter(private val imageResIds: List<Int>) :
    RecyclerView.Adapter<ImageSliderAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_image_slider, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val resId = imageResIds[position]
        Glide.with(holder.imageView.context)
            .load(resId)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return imageResIds.size
    }
}
