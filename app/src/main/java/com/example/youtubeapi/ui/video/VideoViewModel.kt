package com.example.youtubeapi.ui.video

import androidx.lifecycle.LiveData
import com.example.youtubeapi.App.Companion.repository
import com.example.youtubeapi.core.network.result.Resource
import com.example.youtubeapi.core.ui.BaseViewModel
import com.example.youtubeapi.data.remote.model.VideoItem

class VideoViewModel : BaseViewModel() {

    fun getVideos(videoId: String): LiveData<Resource<VideoItem>> {
        return repository.getVideos(videoId)
    }
}