package com.example.project.home.home_hotline.hotline_psikolog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.project.R
import com.example.project.account.AccountActivity
import com.example.project.home.home_hotline.HotlineActivity

class Psikolog : AppCompatActivity() {

    private lateinit var kembali : ImageView
    private lateinit var akun : ImageView
    private lateinit var chat_psikolog2 : Button
    private lateinit var chat_psikolog3 : Button
    private lateinit var chat_psikolog4 : Button
    private lateinit var chat_psikolog1 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_psikolog)

        button()
    }
    private fun button() {
        kembali = findViewById(R.id.back)
        kembali.setOnClickListener {
            startActivity(Intent(this, HotlineActivity::class.java))
        }
        akun = findViewById(R.id.akun_psikolog)
        akun.setOnClickListener {
            startActivity(Intent(this, AccountActivity::class.java))
        }
        chat_psikolog1 = findViewById(R.id.btn_psikolog1)
        chat_psikolog1.setOnClickListener {
            startActivity(Intent(this, Psikolog1::class.java))
        }
        chat_psikolog2 = findViewById(R.id.btn_psikolog2)
        chat_psikolog2.setOnClickListener {
            startActivity(Intent(this, Psikolog2::class.java))
        }
        chat_psikolog3 = findViewById(R.id.btn_psikolog3)
        chat_psikolog3.setOnClickListener {
            startActivity(Intent(this, Psikolog3::class.java))
        }
        chat_psikolog4 = findViewById(R.id.btn_psikolog4)
        chat_psikolog4.setOnClickListener {
            startActivity(Intent(this, Psikolog4::class.java))
        }
    }
}