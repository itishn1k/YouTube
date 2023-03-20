package com.example.youtubeapi.ui.playlists

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi.App.Companion.KEY
import com.example.youtubeapi.App.Companion.KEY_DESC
import com.example.youtubeapi.App.Companion.KEY_TITLE
import com.example.youtubeapi.R
import com.example.youtubeapi.core.ui.BaseActivity
import com.example.youtubeapi.databinding.PlaylistsMainBinding
import com.example.youtubeapi.ui.detail.DetailActivity
import com.example.youtubeapi.core.utils.ConnectionLiveData
import com.example.youtubeapi.core.extention.isNetworkConnected
import com.example.youtubeapi.core.extention.showToast
import com.example.youtubeapi.core.network.result.Status

class PlayListsActivity : BaseActivity<PlayListsViewModel, PlaylistsMainBinding>() {
    private lateinit var adapter: PlaylistsAdapter
    override val viewModel: PlayListsViewModel by lazy {
        ViewModelProvider(this)[PlayListsViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.toolbar.tvBack.isVisible = false
        checkInternet()
    }

    override fun initListener() {
        adapter = PlaylistsAdapter {
            val intent = Intent(this@PlayListsActivity, DetailActivity::class.java)
            intent.putExtra(KEY, it.id)
            intent.putExtra(KEY_TITLE, it.snippet.title)
            intent.putExtra(KEY_DESC, it.snippet.description)
            startActivity(intent)
        }
    }

    override fun inflateViewBinding(inflater: LayoutInflater): PlaylistsMainBinding {
        return PlaylistsMainBinding.inflate(layoutInflater)
    }

    override fun checkInternet() {
        super.checkInternet()
        val cld = ConnectionLiveData(application)
        cld.observe(this) {
            if (!it) {
                binding.noInternet.isVisible = true
                binding.include.btnTryAgain.setOnClickListener {
                    if (!isNetworkConnected()) {
                        showToast(getString(R.string.no_internet))
                    } else {
                        binding.noInternet.isVisible = false
                    }
                }
            } else {
                setPlaylists()
            }
        }
    }

    private fun setPlaylists() {
        viewModel.loading.observe(this) {
            binding.progressCircular.isVisible = it
        }

        viewModel.getPlaylists().observe(this) {
            binding.rvPlaylists.adapter = adapter
            when (it.status) {
                Status.LOADING -> {
                    viewModel.loading.postValue(true)
                }
                Status.SUCCESS -> {
                    viewModel.loading.postValue(false)
                    it.data?.items?.let { it1 -> adapter.setData(it1) }
                }
                Status.ERROR -> {
                    viewModel.loading.postValue(false)
                    showToast(it.message.toString())
                }
            }
        }
    }
}
