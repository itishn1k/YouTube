package com.example.youtubeapi.remote

import com.example.youtubeapi.App
import com.example.youtubeapi.BuildConfig
import com.example.youtubeapi.core.network.BaseDataSource
import com.example.youtubeapi.core.network.RetrofitClient

class RemoteDataSource : BaseDataSource() {
    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    suspend fun getPlaylists() = getResult {
        apiService.getPlaylists(BuildConfig.API_KEY, App.PART, App.CHANNEL_ID)
    }


    suspend fun getPlaylistItems(playlistId: String) = getResult {
        apiService.getPlaylistItems(BuildConfig.API_KEY, App.PART, playlistId)
    }


    suspend fun getVideos(videoId: String) = getResult {
        apiService.getVideos(BuildConfig.API_KEY, App.PART, videoId)
    }
}