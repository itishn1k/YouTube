package com.example.youtubeapi.remote

import com.example.youtubeapi.model.playlist.Item
import com.example.youtubeapi.model.playlist.Playlists
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("playlists")
    fun getPlaylists(
        @Query("key") apiKey: String,
        @Query("part") part: String,
        @Query("channelId") channelId: String

    ): Call<Playlists>

    @GET("playlistItems")
    fun getItemLists(
        @Query("key") key: String,
        @Query("part") part: String,
        @Query("playlistId") id: String,
        ):Call<Item>
}