package com.example.apicaller

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.github.farshidroohi.AdapterRecyclerView

class VideoAdapter : AdapterRecyclerView<Video>(R.layout.item_video, 0, 0, 0) {
    override fun onBindView(
        viewHolder: RecyclerView.ViewHolder,
        position: Int,
        context: Context,
        element: Video?
    ) {

        val imageView: ImageView = viewHolder.itemView.findViewById<ImageView>(R.id.imgVideo)
        val txtTitle: TextView = viewHolder.itemView.findViewById<TextView>(R.id.txtTitle)
        val title=element!!.title
        val url: String? = element.smallPoster;

        txtTitle.text= title
        Glide.with(context).load(url).into(imageView);
    }


}