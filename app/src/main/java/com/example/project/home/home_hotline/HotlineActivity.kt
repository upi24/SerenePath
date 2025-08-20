package com.example.project.home.home_hotline

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import com.example.project.R
import com.example.project.account.AccountActivity
import com.example.project.home.HomeActivity
import com.example.project.home.home_hotline.hotline_psikolog.Psikolog

class HotlineActivity : AppCompatActivity() {

    private lateinit var menu1 : CardView
    private lateinit var kembali : ImageView
    private lateinit var akun : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotline)

        val tombolChat: View = findViewById(R.id.card_pencegahan)

        tombolChat.setOnClickListener {
            pencegahan()
        }

        button()
    }
    private fun button() {
        menu1 = findViewById(R.id.card_psikolog)
        menu1.setOnClickListener {
            startActivity(Intent(this, Psikolog::class.java))
        }
        kembali = findViewById(R.id.back)
        kembali.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        akun = findViewById(R.id.akun_icon)
        akun.setOnClickListener {
            startActivity(Intent(this, AccountActivity::class.java))
        }
    }
    private fun pencegahan() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Serene Path")
        builder.setMessage("Fitur Segera Datang")

        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            if (which == DialogInterface.BUTTON_POSITIVE) {
                dialog.dismiss()
            }
        }
        builder.show()
    }
}