package com.example.recyclerviewwithkotlin

import android.R
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_main2.*


class Main2Activity : AppCompatActivity(R.layout.activity_main2) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val player = SimpleExoPlayer.Builder(this).build()
        var dataSourceFactory: DataSource.Factory =
            DefaultDataSourceFactory(this, Util.getUserAgent(this, "recyclerviewwithkotlin"))
        var videoSource: MediaSource =
            ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(
                Uri.parse("https://www.youtube.com/watch?v=GNR9El3XWYo")
            )
        player.prepare(videoSource)
        playerView.setPlayer(player);


    }
}
