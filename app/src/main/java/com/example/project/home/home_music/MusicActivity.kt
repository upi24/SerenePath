package com.example.project.home.home_music

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.project.R
import com.example.project.account.AccountActivity
import com.example.project.home.HomeActivity

class MusicActivity : AppCompatActivity() {

    private lateinit var kembali: ImageView
    private lateinit var akun: ImageView
    private lateinit var btnMusic1: ImageView
    private lateinit var btnMusic2: ImageView
    private lateinit var btnMusic3: ImageView
    private lateinit var btnMusic4: ImageView
    private lateinit var btnMusic5: ImageView
    private lateinit var mediaPlayer1: MediaPlayer
    private lateinit var mediaPlayer2: MediaPlayer
    private lateinit var mediaPlayer3: MediaPlayer
    private lateinit var mediaPlayer4: MediaPlayer
    private lateinit var mediaPlayer5: MediaPlayer
    private var isPlaying1: Boolean = false
    private var isPlaying2: Boolean = false
    private var isPlaying3: Boolean = false
    private var isPlaying4: Boolean = false
    private var isPlaying5: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)

        button()

        mediaPlayer1 = MediaPlayer.create(this, R.raw.music1)
        mediaPlayer2 = MediaPlayer.create(this, R.raw.music2)
        mediaPlayer3 = MediaPlayer.create(this, R.raw.music3)
        mediaPlayer4 = MediaPlayer.create(this, R.raw.music4)
        mediaPlayer5 = MediaPlayer.create(this, R.raw.music5)
    }

    private fun button() {
        btnMusic1 = findViewById(R.id.play_music1)
        btnMusic2 = findViewById(R.id.play_music2)
        btnMusic3 = findViewById(R.id.play_music3)
        btnMusic4 = findViewById(R.id.play_music4)
        btnMusic5 = findViewById(R.id.play_music5)

        kembali = findViewById(R.id.back)
        kembali.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        akun = findViewById(R.id.akun_music)
        akun.setOnClickListener {
            startActivity(Intent(this, AccountActivity::class.java))
        }

        btnMusic1.setOnClickListener {
            handleMusicButtonClick(mediaPlayer1, btnMusic1, isPlaying1)
            isPlaying1 = !isPlaying1
        }

        btnMusic2.setOnClickListener {
            handleMusicButtonClick(mediaPlayer2, btnMusic2, isPlaying2)
            isPlaying2 = !isPlaying2
        }

        btnMusic3.setOnClickListener {
            handleMusicButtonClick(mediaPlayer3, btnMusic3, isPlaying3)
            isPlaying3 = !isPlaying3
        }
        btnMusic4.setOnClickListener {
            handleMusicButtonClick(mediaPlayer4, btnMusic4, isPlaying4)
            isPlaying4 = !isPlaying4
        }
        btnMusic5.setOnClickListener {
            handleMusicButtonClick(mediaPlayer5, btnMusic5, isPlaying5)
            isPlaying5 = !isPlaying5
        }
    }

    private fun handleMusicButtonClick(mediaPlayer: MediaPlayer, button: ImageView, isPlaying: Boolean) {
        if (isPlaying) {
            mediaPlayer.pause()
            button.setImageResource(R.drawable.pause)
        } else {
            mediaPlayer.start()
            button.setImageResource(R.drawable.play)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer1.release()
        mediaPlayer2.release()
        mediaPlayer3.release()
        mediaPlayer4.release()
        mediaPlayer5.release()
    }
}
