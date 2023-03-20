package com.example.youtubeapi.ui.video

import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.youtubeapi.App.Companion.KEY
import com.example.youtubeapi.App.Companion.KEY_DESC
import com.example.youtubeapi.App.Companion.KEY_TITLE
import com.example.youtubeapi.core.ui.BaseActivity
import com.example.youtubeapi.databinding.ActivityVideoBinding

class VideoActivity : BaseActivity<VideoViewModel, ActivityVideoBinding>() {

    override val viewModel: VideoViewModel by lazy {
        ViewModelProvider(this)[VideoViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityVideoBinding {
        return ActivityVideoBinding.inflate(layoutInflater)
    }

    override fun initListener() {
        super.initListener()
        binding.toolbar.tvBack.setOnClickListener {
            finish()
        }
    }
    override fun initViewModel() {
        super.initViewModel()
        val title = intent.getStringExtra(KEY_TITLE)
        val desc = intent.getStringExtra(KEY_DESC)
        val id = intent.getStringExtra(KEY)
        if (id != null) {
            viewModel.getVideos(id)
            binding.tvVideoName.text = title
            binding.tvDescription.text = desc
        }
    }
}