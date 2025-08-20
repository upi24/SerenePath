package com.example.project.home.home_hotline.hotline_psikolog

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.project.R
import com.example.project.home.home_hotline.HotlineActivity

class Psikolog4 : AppCompatActivity() {

    private lateinit var kembali : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_psikolog4)

        button()

        val tombolChat: View = findViewById(R.id.chat_p4)

        tombolChat.setOnClickListener {
            logout()
        }
    }

    private fun button() {
        kembali = findViewById(R.id.back4)
        kembali.setOnClickListener {
            startActivity(Intent(this, Psikolog::class.java))
        }
    }

    private fun logout() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Serene Path")
        builder.setMessage("Fitur Segera Datang")

        builder.setPositiveButton(android.R.string.yes) { dialog, which ->
            finish()
        }
        builder.show()
    }
}
