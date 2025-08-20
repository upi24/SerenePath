package com.example.project.home

import com.example.project.account.AccountActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.example.project.R
import com.example.project.home.home_about.AboutActivity
import com.example.project.home.home_article.SereneArticle
import com.example.project.home.home_conditions.DailyCondition
import com.example.project.home.home_hotline.HotlineActivity
import com.example.project.home.home_music.MusicActivity

class HomeActivity : AppCompatActivity() {

    lateinit var menu1 : CardView
    lateinit var menu2 : CardView
    lateinit var menu3 : CardView
    lateinit var menu4 : CardView
    lateinit var menu5 : CardView
    lateinit var akun : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        button()
    }
    fun button() {
        menu1 = findViewById(R.id.card_daily)
        menu1.setOnClickListener {
            startActivity(Intent(this, DailyCondition::class.java))
        }
        menu2 = findViewById(R.id.card_article)
        menu2.setOnClickListener {
            startActivity(Intent(this, SereneArticle::class.java))
        }
        menu3 = findViewById(R.id.card_hotline)
        menu3.setOnClickListener {
            startActivity(Intent(this, HotlineActivity::class.java))
        }
        menu4 = findViewById(R.id.card_music)
        menu4.setOnClickListener {
            startActivity(Intent(this, MusicActivity::class.java))
        }
        menu5 = findViewById(R.id.card_about)
        menu5.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }
        akun = findViewById(R.id.account_home)
        akun.setOnClickListener {
            startActivity(Intent(this, AccountActivity::class.java))
        }
    }
}