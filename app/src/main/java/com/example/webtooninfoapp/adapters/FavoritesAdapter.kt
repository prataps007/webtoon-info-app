package com.example.webtooninfoapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.webtooninfoapp.R
import com.example.webtooninfoapp.entities.FavoriteWebtoonEntity

class FavoritesAdapter : ListAdapter<FavoriteWebtoonEntity, FavoritesAdapter.FavoritesViewHolder>(FavoritesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite_webtoon, parent, false)
        return FavoritesViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        val favoriteWebtoon = getItem(position)
        holder.bind(favoriteWebtoon)
    }

    inner class FavoritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(webtoon: FavoriteWebtoonEntity) {
            itemView.findViewById<TextView>(R.id.titleTextView).text = webtoon.title
            itemView.findViewById<TextView>(R.id.descriptionTextView).text = webtoon.description
            itemView.findViewById<ImageView>(R.id.webtoonImageView).setImageResource(webtoon.imageResId)
        }
    }
}

class FavoritesDiffCallback : DiffUtil.ItemCallback<FavoriteWebtoonEntity>() {
    override fun areItemsTheSame(oldItem: FavoriteWebtoonEntity, newItem: FavoriteWebtoonEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: FavoriteWebtoonEntity, newItem: FavoriteWebtoonEntity): Boolean {
        return oldItem == newItem
    }
}

