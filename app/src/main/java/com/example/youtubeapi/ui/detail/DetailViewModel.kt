package com.example.youtubeapi.ui.detail

import androidx.lifecycle.LiveData
import com.example.youtubeapi.App
import com.example.youtubeapi.base.BaseViewModel
import com.example.youtubeapi.model.PlaylistItem

class DetailViewModel : BaseViewModel() {
    fun getItemLists(id: String): LiveData<PlaylistItem> {
        return App().repository.getItemList(id)
    }
}