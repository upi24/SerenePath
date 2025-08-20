package com.example.project.home.home_article

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.example.project.R
import com.example.project.account.AccountActivity
import com.example.project.home.HomeActivity

class SereneArticle : AppCompatActivity() {

    private lateinit var art1 : CardView
    private lateinit var art2 : CardView
    private lateinit var art3 : CardView
    private lateinit var art4 : CardView
    private lateinit var art5 : CardView
    private lateinit var art6 : CardView
    private lateinit var kembali : ImageView
    private lateinit var akun : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serene_article)

        button()
    }
    private fun button() {
        art1 = findViewById(R.id.article_card1)
        art1.setOnClickListener {
            startActivity(Intent(this, Article1::class.java))
        }
        art2 = findViewById(R.id.article_card2)
        art2.setOnClickListener {
            startActivity(Intent(this, Article2::class.java))
        }
        art3 = findViewById(R.id.article_card3)
        art3.setOnClickListener {
            startActivity(Intent(this, Article3::class.java))
        }
        art4 = findViewById(R.id.article_card4)
        art4.setOnClickListener {
            startActivity(Intent(this, Article4::class.java))
        }
        art5 = findViewById(R.id.article_card5)
        art5.setOnClickListener {
            startActivity(Intent(this, Article5::class.java))
        }
        art6 = findViewById(R.id.article_card6)
        art6.setOnClickListener {
            startActivity(Intent(this, Article6::class.java))
        }
        kembali = findViewById(R.id.back_article)
        kembali.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        akun = findViewById(R.id.akun_article)
        akun.setOnClickListener {
            startActivity(Intent(this, AccountActivity::class.java))
        }
    }
}