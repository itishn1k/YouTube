package com.example.youtubeapi.ui.playlists

import androidx.lifecycle.LiveData
import com.example.youtubeapi.App.Companion.repository
import com.example.youtubeapi.core.ui.BaseViewModel
import com.example.youtubeapi.model.Playlists

class PlayListsViewModel : BaseViewModel() {
    fun getPlaylists(): LiveData<Playlists> {
        return repository.getPlaylists()
    }
}