package com.example.youtubeapi.ui.detail

import androidx.lifecycle.LiveData
import com.example.youtubeapi.App.Companion.repository
import com.example.youtubeapi.core.ui.BaseViewModel
import com.example.youtubeapi.model.PlaylistItem

class DetailViewModel : BaseViewModel() {
    fun getItemLists(id: String): LiveData<PlaylistItem> {
        return repository.getItemList(id)
    }
}