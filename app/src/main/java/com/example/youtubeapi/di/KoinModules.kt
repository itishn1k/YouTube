package com.example.youtubeapi.di

import com.example.youtubeapi.core.network.networkModules
import com.example.youtubeapi.remote.remoteDataSourceModules

val koinModules = listOf(
    repoModules,viewModules,networkModules,remoteDataSourceModules
)
