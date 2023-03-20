package com.example.youtubeapi.remote

import com.example.youtubeapi.data.remote.model.PlaylistItem
import com.example.youtubeapi.data.remote.model.Playlists
import com.example.youtubeapi.data.remote.model.VideoItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("playlists")
    suspend fun getPlaylists(
        @Query("key") key: String,
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("maxResults") maxResults: Int = 20
    ): Response<Playlists>

    @GET("playlistItems")
    suspend fun getPlaylistItems(
        @Query("key") key: String,
        @Query("part") part: String,
        @Query("playlistId") id: String,
        @Query("maxResults") maxResults: Int = 20
    ): Response<PlaylistItem>

    @GET("videos")
    suspend fun getVideos(
        @Query("key") key: String,
        @Query("part") part: String,
        @Query("id") id: String,
    ): Response<VideoItem>
}