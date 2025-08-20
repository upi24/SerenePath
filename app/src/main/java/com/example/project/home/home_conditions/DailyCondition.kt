package com.example.project.home.home_conditions

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.project.R
import com.example.project.account.AccountActivity
import com.example.project.home.HomeActivity

class DailyCondition : AppCompatActivity() {

    private lateinit var kembali: ImageView
    private lateinit var akun: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_condition)

        button()

        val btn_check = findViewById<Button>(R.id.btn_check)
        val editTextInput = findViewById<EditText>(R.id.editTextInput)

        // Inisialisasi data dummy
        val kataPemicuSuksesList = listOf("senang", "ceria", "baik" , "aku sedang senang" ,"aku sedang baik banget", "hari ini aku sedang sangat bahagia", "bahagia", "aku sedang ceria")
        val kataPemicuGagalList = listOf("stres", "sedih", "buruk" , "aku sedang terpuruk", "hari ini aku ingin bunuh diri" ,"aku sedang membawa pisau", "hari ini aku sedang galau", "setres", "galau", "aku ingin menikam seseorang", "sialan")

        btn_check.setOnClickListener {
            val inputText = editTextInput.text.toString()
            tampilkanSuksesBerdasarkanKata(inputText, kataPemicuSuksesList, kataPemicuGagalList)
        }
    }

    private fun button() {
        kembali = findViewById(R.id.back_daily)
        kembali.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        akun = findViewById(R.id.akun_daily)
        akun.setOnClickListener {
            startActivity(Intent(this, AccountActivity::class.java))
        }
    }

    private fun tampilkanSuksesBerdasarkanKata(
        inputText: String,
        kataPemicuSuksesList: List<String>,
        kataPemicuGagalList: List<String>
    ) {
        val imageDaily = findViewById<ImageView>(R.id.img_daily)
        val imageViewSukses = findViewById<ImageView>(R.id.imageViewPopup)
        val textViewSukses = findViewById<TextView>(R.id.textViewPopup)
        val imageViewGagal = findViewById<ImageView>(R.id.imageViewPopup2)
        val textViewGagal = findViewById<TextView>(R.id.textViewPopup2)

        // Cek apakah inputText mengandung kata pemicu sukses atau gagal
        if (kataPemicuSuksesList.any { inputText.contains(it, ignoreCase = true) }) {
            imageDaily.visibility = View.INVISIBLE

            imageViewSukses.visibility = View.VISIBLE
            textViewSukses.visibility = View.VISIBLE

            imageViewGagal.visibility = View.GONE
            textViewGagal.visibility = View.GONE
        } else if (kataPemicuGagalList.any { inputText.contains(it, ignoreCase = true) }) {
            imageDaily.visibility = View.INVISIBLE

            imageViewGagal.visibility = View.VISIBLE
            textViewGagal.visibility = View.VISIBLE

            imageViewSukses.visibility = View.GONE
            textViewSukses.visibility = View.GONE
        } else {
            imageDaily.visibility = View.VISIBLE

            imageViewSukses.visibility = View.GONE
            textViewSukses.visibility = View.GONE
            imageViewGagal.visibility = View.GONE
            textViewGagal.visibility = View.GONE
        }
    }
}
