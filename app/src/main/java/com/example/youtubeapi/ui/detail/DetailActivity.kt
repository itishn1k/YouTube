package com.example.youtubeapi.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi.App.Companion.KEY
import com.example.youtubeapi.R
import com.example.youtubeapi.base.BaseActivity
import com.example.youtubeapi.databinding.ActivityDetailBinding
import com.example.youtubeapi.utils.ConnectionLiveData
import com.example.youtubeapi.utils.isNetworkConnected
import com.example.youtubeapi.utils.showToast

class DetailActivity : BaseActivity<DetailViewModel, ActivityDetailBinding>() {
    private lateinit var adapter: DetailAdapter

    override val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this)[DetailViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun initListener() {
        binding.toolbar.tvBack.setOnClickListener {
            finish()
        }
    }

    override fun checkInternet() {
        val cld = ConnectionLiveData(application)
        cld.observe(this) { isConnected ->
            binding.noInternet.root.isVisible = !isConnected
            binding.noInternet.btnTryAgain.setOnClickListener {
                if (!isNetworkConnected()) {
                    showToast(getString(R.string.no_internet))
                } else {
                    binding.noInternet.root.isVisible = false
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = DetailAdapter()
        setItems()
    }

    private fun setItems() {
        val id = intent.getStringExtra(KEY)
        id?.let { _ ->
            viewModel.getItemLists(id).observe(this) {
                binding.rvItems.adapter = adapter
                adapter.setItems(it.items)
            }
        }
    }
}