package com.example.youtubeapi.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.youtubeapi.databinding.ItemPlaylistBinding
import com.example.youtubeapi.data.remote.model.Item

class DetailAdapter :
    RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    private val items = arrayListOf<Item>()

    inner class DetailViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.ivItem.load(item.snippet.thumbnails.medium.url)
            binding.tvTitle.text = item.snippet.title
            binding.blackBar.isVisible = false
            binding.tvTimeOrVideos.text = item.snippet.publishedAt
        }
    }

    fun setItems(list: List<Item>) {
        items.clear()
        items.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind(items[position])
    }
}
