package com.example.project.awal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.project.R
import com.example.project.home.HomeActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var edtUsername_log: EditText
    lateinit var edtPassword_log: EditText
    lateinit var btn_login: Button
    lateinit var auth: FirebaseAuth
    lateinit var kembali: ImageView
    lateinit var register : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button()

        auth = FirebaseAuth.getInstance()

        edtUsername_log = findViewById(R.id.edtUsername_log)
        edtPassword_log = findViewById(R.id.edtPassword_log)
        btn_login = findViewById(R.id.btn_login)

        btn_login.setOnClickListener {
            val username = edtUsername_log.text.toString()
            val email = edtUsername_log.text.toString()
            val password = edtPassword_log.text.toString()

            if (username.isEmpty()) {
                Toast.makeText(this, "Username/Email tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                Toast.makeText(this, "Username/Email tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Email tidak valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            loginFirebase(username, email, password)
        }
    }

        private fun loginFirebase(username: String, email: String, password: String) {
            val loginEmail = if (Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
                username
            } else {
                email
            }

            auth.signInWithEmailAndPassword(loginEmail, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, HomeActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Email/Password Salah", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        private fun button() {
        kembali = findViewById(R.id.back_log)
        kembali.setOnClickListener {
            startActivity(Intent(this, LandingActivity::class.java))
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
            finish()
        }
            register = findViewById(R.id.txt_register)
            register.setOnClickListener {
                startActivity(Intent(this, RegisterActivity::class.java))
            }
    }
}
