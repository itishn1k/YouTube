package com.example.youtubeapi

import android.app.Application
import com.example.youtubeapi.di.koinModules
import com.example.youtubeapi.repository.Repository
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(koinModules)
        }
    }
    companion object {
        const val CHANNEL_ID = "UCt7sv-NKh44rHAEb-qCCxvA"
        const val PART = "snippet,contentDetails"
        const val KEY: String = "key"
        const val KEY_TITLE: String = "title"
        const val KEY_DESC: String = "desc"
        const val KEY_ITEM_COUNT: String = "desc"
        const val PLAYLIST_INFO = "playlist.info"
    }
}