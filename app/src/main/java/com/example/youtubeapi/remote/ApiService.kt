package com.example.youtubeapi.remote

import com.example.youtubeapi.model.PlaylistItem
import com.example.youtubeapi.model.Playlists
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("playlists")
    fun getPlaylists(
        @Query("key") key: String,
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("maxResults") maxResults: Int = 20
    ): Call<Playlists>

    @GET("playlistItems")
    fun getItemLists(
        @Query("key") key: String,
        @Query("part") part: String,
        @Query("playlistId") id: String,
        @Query("maxResults") maxResults: Int = 20
    ): Call<PlaylistItem>
}