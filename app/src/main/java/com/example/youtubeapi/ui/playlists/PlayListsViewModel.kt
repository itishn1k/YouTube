package com.example.youtubeapi.ui.playlists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapi.App
import com.example.youtubeapi.BuildConfig
import com.example.youtubeapi.model.playlist.Playlists
import com.example.youtubeapi.base.BaseViewModel
import com.example.youtubeapi.remote.ApiService
import com.example.youtubeapi.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayListsViewModel : BaseViewModel() {

    fun getPlaylists(): LiveData<Playlists> {
        return App().repository.getPlaylists()
    }
}