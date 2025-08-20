package com.example.project.home.home_about

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.example.project.R
import com.example.project.account.AccountActivity
import com.example.project.home.HomeActivity
import com.example.project.home.home_article.SereneArticle
import com.example.project.home.home_conditions.DailyCondition
import com.example.project.home.home_hotline.HotlineActivity
import com.example.project.home.home_music.MusicActivity

class AboutActivity : AppCompatActivity() {

    private lateinit var kembali : ImageView
    private lateinit var akun : ImageView
    private lateinit var card1 : CardView
    private lateinit var card2 : CardView
    private lateinit var card3 : CardView
    private lateinit var card4 : CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        button()
    }
    private fun button(){
        kembali = findViewById(R.id.back)
        kembali.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        akun = findViewById(R.id.akun_about)
        akun.setOnClickListener {
            startActivity(Intent(this, AccountActivity::class.java))
        }
        card1 = findViewById(R.id.card1_about)
        card1.setOnClickListener {
            startActivity(Intent(this, DailyCondition::class.java))
        }
        card2 = findViewById(R.id.card2_about)
        card2.setOnClickListener {
            startActivity(Intent(this, SereneArticle::class.java))
        }
        card3 = findViewById(R.id.card3_about)
        card3.setOnClickListener {
            startActivity(Intent(this, HotlineActivity::class.java))
        }
        card4 = findViewById(R.id.card4_about)
        card4.setOnClickListener {
            startActivity(Intent(this, MusicActivity::class.java))
        }
    }
}