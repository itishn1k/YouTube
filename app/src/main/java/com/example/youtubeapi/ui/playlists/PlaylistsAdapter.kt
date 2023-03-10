package com.example.youtubeapi.ui.playlists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.youtubeapi.databinding.ItemPlaylistBinding
import com.example.youtubeapi.model.playlist.Item

class PlaylistsAdapter : RecyclerView.Adapter<PlaylistsAdapter.PlaylistsViewHolder>() {
    private var playlists = arrayListOf<Item>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistsViewHolder {
        return PlaylistsViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return playlists.size
    }

    override fun onBindViewHolder(holder: PlaylistsViewHolder, position: Int) {
        holder.bind(playlists[position])
    }

    inner class PlaylistsViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(playlists: Item) {
            binding.ivItem.load(playlists.snippet.thumbnails.medium.url)
            binding.tvTitle.text = playlists.snippet.title
            binding.tvTimeOrVideos.text = playlists.contentDetails.itemCount.toString()
        }
    }
}