package com.example.recyclerviewwithkotlin

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val player = SimpleExoPlayer.Builder(this).build()
        var dataSourceFactory: DataSource.Factory =
            DefaultDataSourceFactory(this, Util.getUserAgent(this, "recyclerviewwithkotlin"))
        var videoSource: MediaSource =
            ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(
                Uri.parse("https://drive.google.com/file/d/13Y-Bldnb32_kUx4bGiqAJOaaL_qddPy8yA/view?usp=sharing")
            )
        player.prepare(videoSource)
        playerView.setPlayer(player);
    }
}
