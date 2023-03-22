package com.example.youtubeapi.ui.video

import android.os.Bundle
import android.view.LayoutInflater
import com.example.youtubeapi.App.Companion.KEY
import com.example.youtubeapi.App.Companion.KEY_DESC
import com.example.youtubeapi.App.Companion.KEY_TITLE
import com.example.youtubeapi.core.ui.BaseActivity
import com.example.youtubeapi.databinding.ActivityVideoBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.dash.DashMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import org.koin.androidx.viewmodel.ext.android.viewModel

class VideoActivity : BaseActivity<VideoViewModel, ActivityVideoBinding>() {
    private var exoPlayer: ExoPlayer? = null
    private var playbackPosition = 0L
    private var playWhenReady = true

    override val viewModel: VideoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preparePlayer()
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
    private fun preparePlayer() {
        exoPlayer = ExoPlayer.Builder(this).build()
        exoPlayer?.playWhenReady = true
        binding.exoPlayer.player = exoPlayer
        val defaultHttpDataSourceFactory = DefaultHttpDataSource.Factory()
        val mediaItem = MediaItem.fromUri(URL)
        val mediaSource =
            DashMediaSource.Factory(defaultHttpDataSourceFactory).createMediaSource(mediaItem)
        exoPlayer?.setMediaSource(mediaSource)
        exoPlayer?.seekTo(playbackPosition)
        exoPlayer?.playWhenReady = playWhenReady
        exoPlayer?.prepare()
    }

    private fun  realisePlayer(){
        exoPlayer?.let { player ->
            playbackPosition = player.currentPosition
            playWhenReady = player.playWhenReady
            player.release()
            exoPlayer = null
        }
    }

    override fun onStop() {
        super.onStop()
        realisePlayer()
    }

    override fun onPause() {
        super.onPause()
        realisePlayer()
    }

    override fun onDestroy() {
        super.onDestroy()
        realisePlayer()
    }

    companion object{
        const val URL =
            "https://bitmovin-a.akamaihd.net/content/MI201109210084_1/mpds/f08e80da-bf1d-4e3d-8899-f0f6155f6efa.mpd"
    }
}