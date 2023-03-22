package com.example.youtubeapi.ui.detail

import androidx.lifecycle.LiveData
import com.example.youtubeapi.core.network.result.Resource
import com.example.youtubeapi.core.ui.BaseViewModel
import com.example.youtubeapi.data.remote.model.PlaylistItem
import com.example.youtubeapi.repository.Repository

class DetailViewModel(private val repository: Repository) : BaseViewModel() {
    fun getItemsList(id: String): LiveData<Resource<PlaylistItem>> {
        return repository.getPlaylistItems(id)
    }
}