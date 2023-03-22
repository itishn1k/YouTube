package com.example.youtubeapi.ui.video

import androidx.lifecycle.LiveData
import com.example.youtubeapi.core.network.result.Resource
import com.example.youtubeapi.core.ui.BaseViewModel
import com.example.youtubeapi.data.remote.model.VideoItem
import com.example.youtubeapi.repository.Repository

class VideoViewModel(private val repository: Repository) : BaseViewModel() {

    fun getVideos(videoId: String): LiveData<Resource<VideoItem>> {
        return repository.getVideos(videoId)
    }
}