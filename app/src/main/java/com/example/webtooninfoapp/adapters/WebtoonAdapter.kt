package com.example.webtooninfoapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.webtooninfoapp.R
import com.example.webtooninfoapp.Webtoon

class WebtoonAdapter(private val webtoonList: List<Webtoon>, private val onItemClick: (Webtoon) -> Unit)
    : RecyclerView.Adapter<WebtoonAdapter.WebtoonViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebtoonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_webtoon, parent, false)
        return WebtoonViewHolder(view)
    }

    inner class WebtoonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val webtoonImage: ImageView = itemView.findViewById(R.id.webtoon_image)
        val webtoonTitle: TextView = itemView.findViewById(R.id.webtoon_title)
        val webtoonDescription: TextView = itemView.findViewById(R.id.webtoon_description)
    }

    override fun onBindViewHolder(holder: WebtoonViewHolder, position: Int) {
        val webtoon = webtoonList[position]
        holder.webtoonTitle.text = webtoon.title
        holder.webtoonDescription.text = webtoon.description

        // set the image from drawable resource
        holder.webtoonImage.setImageResource(webtoon.imageResId)

        holder.itemView.setOnClickListener {
            onItemClick(webtoon)
        }
    }

    override fun getItemCount(): Int = webtoonList.size

//    fun filter(query: String?) {
//        filteredWebtoons = if (query.isNullOrEmpty()) {
//            webtoonList
//        } else {
//            webtoonList.filter {
//                it.title.contains(query, true) || it.description.contains(query, true)
//            }
//        }
//        notifyDataSetChanged()
//    }
}
