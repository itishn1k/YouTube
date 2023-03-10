package com.example.youtubeapi.ui.playlists

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi.R
import com.example.youtubeapi.base.BaseActivity
import com.example.youtubeapi.databinding.PlaylistsMainBinding
import com.example.youtubeapi.utils.isNetworkConnected

class PlayListsActivity : BaseActivity<PlayListsViewModel, PlaylistsMainBinding>() {
    private lateinit var adapter: PlaylistsAdapter

    override val viewModel: PlayListsViewModel by lazy {
        ViewModelProvider(this)[PlayListsViewModel::class.java]
    }

    override fun checkInternet() {
        if (!isNetworkConnected()) {
            setContentView(R.layout.no_internet)
        }
        else{
            initView()
        }
    }

    override fun inflateViewBinding(inflater: LayoutInflater): PlaylistsMainBinding {
        return PlaylistsMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        }
    }
