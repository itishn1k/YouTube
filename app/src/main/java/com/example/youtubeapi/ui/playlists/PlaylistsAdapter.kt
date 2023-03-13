package com.example.youtubeapi.ui.playlists

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.youtubeapi.databinding.ItemPlaylistBinding
import com.example.youtubeapi.model.Item

class PlaylistsAdapter(val onClick: (Item) -> Unit) :
    RecyclerView.Adapter<PlaylistsAdapter.PlaylistsViewHolder>() {

    private var playlists = arrayListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistsViewHolder {
        return PlaylistsViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    fun setData(list: List<Item>) {
        playlists.addAll(list)
    }

    override fun getItemCount(): Int {
        return playlists.size
    }

    override fun onBindViewHolder(holder: PlaylistsViewHolder, position: Int) {
        holder.bind(playlists[position])
    }

    inner class PlaylistsViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(playlists: Item) {
            binding.ivItem.load(playlists.snippet.thumbnails.medium.url)
            binding.tvTitle.text = playlists.snippet.title
            binding.tvTimeOrVideos.text = "${playlists.contentDetails.itemCount} video series"
            itemView.setOnClickListener {
                onClick(playlists)
            }
        }
    }
}