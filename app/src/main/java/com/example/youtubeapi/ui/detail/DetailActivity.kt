package com.example.youtubeapi.ui.detail


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.view.isVisible
import com.example.youtubeapi.App.Companion.KEY
import com.example.youtubeapi.App.Companion.KEY_DESC
import com.example.youtubeapi.App.Companion.KEY_TITLE
import com.example.youtubeapi.R
import com.example.youtubeapi.core.extention.isNetworkConnected
import com.example.youtubeapi.core.extention.showToast
import com.example.youtubeapi.core.ui.BaseActivity
import com.example.youtubeapi.core.utils.ConnectionLiveData
import com.example.youtubeapi.databinding.ActivityDetailBinding
import com.example.youtubeapi.ui.video.VideoActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : BaseActivity<DetailViewModel, ActivityDetailBinding>() {
    private lateinit var adapter: DetailAdapter

    override val viewModel: DetailViewModel by viewModel()

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun initListener() {
        adapter = DetailAdapter {
            val intent = Intent(this@DetailActivity, VideoActivity::class.java)
            intent.putExtra(KEY, it.id)
            intent.putExtra(KEY_TITLE, it.snippet.title)
            intent.putExtra(KEY_DESC, it.snippet.description)
            startActivity(intent)
        }
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
        setItems()
    }

    private fun setItems() {
        val title = intent.getStringExtra(KEY_TITLE)
        val desc = intent.getStringExtra(KEY_DESC)
        val id = intent.getStringExtra(KEY)
        id?.let { _ ->
            viewModel.getItemsList(id).observe(this) {
                binding.rvItems.adapter = adapter
                adapter.setItems(it.data?.items)
                binding.tvTitleDetail.text = title
                binding.tvPlaylistDescription.text = desc
            }
        }
    }
}