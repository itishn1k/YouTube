package com.example.youtubeapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.youtubeapi.core.network.result.Resource
import com.example.youtubeapi.data.remote.model.Playlists
import com.example.youtubeapi.remote.RemoteDataSource
import kotlinx.coroutines.Dispatchers

open class Repository {
    private val dataSource: RemoteDataSource by lazy {
        RemoteDataSource()
    }

    fun getPlaylists(): LiveData<Resource<Playlists>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val response = dataSource.getPlaylists()
        emit(response)
    }

    fun getPlaylistItems(playlistId: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val response = dataSource.getPlaylistItems(playlistId)
        emit(response)
    }

    fun getVideos(videoId: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val response = dataSource.getVideos(videoId)
        emit(response)
    }
}