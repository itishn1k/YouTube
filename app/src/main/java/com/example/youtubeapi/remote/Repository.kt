package com.example.youtubeapi.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapi.App
import com.example.youtubeapi.BuildConfig
import com.example.youtubeapi.model.playlist.Item
import com.example.youtubeapi.model.playlist.Playlists
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class Repository {
    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun getPlaylists(): LiveData<Playlists> {
        val data = MutableLiveData<Playlists>()
        apiService.getPlaylists(
            BuildConfig.API_KEY, App.PART, App.CHANNEL_ID
        ).enqueue(object : Callback<Playlists> {
            override fun onResponse(call: Call<Playlists>, response: Response<Playlists>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<Playlists>, t: Throwable) {
                Log.e("ololo", "${t.message}")
            }
        })
        return data
    }

    fun getItemList(id: String): LiveData<Item> {
        val data = MutableLiveData<Item>()
        apiService.getItemLists(BuildConfig.API_KEY, App.PART, "id")
            .enqueue(object : Callback<Item> {
                override fun onResponse(
                    call: Call<Item>, response: Response<Item>
                ) {
                    if (response.isSuccessful) {
                        data.value = response.body()
                    }
                }

                override fun onFailure(call: Call<Item>, t: Throwable) {
                    print(t.stackTrace)
                }
            })
        return data
    }
}