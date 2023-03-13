package com.example.youtubeapi.ui.playlists

import androidx.lifecycle.LiveData
import com.example.youtubeapi.App
import com.example.youtubeapi.base.BaseViewModel
import com.example.youtubeapi.model.Playlists

class PlayListsViewModel : BaseViewModel() {
    fun getPlaylists(): LiveData<Playlists> {
        return App().repository.getPlaylists()
    }
}