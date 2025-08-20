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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegisterActivity : AppCompatActivity() {

    lateinit var edtUsername_reg : EditText
    lateinit var edtEmail_reg : EditText
    lateinit var edtPassword_reg : EditText
    lateinit var btn_register : Button
    lateinit var auth: FirebaseAuth
    lateinit var kembali: ImageView
    lateinit var login : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        button()

        auth = FirebaseAuth.getInstance()

        edtUsername_reg = findViewById(R.id.edtUsername_reg)
        edtEmail_reg = findViewById(R.id.edtEmail_reg)
        edtPassword_reg = findViewById(R.id.edtPassword_reg)
        btn_register = findViewById(R.id.btn_register)

        btn_register.setOnClickListener {
            val username = edtUsername_reg.text.toString()
            val email = edtEmail_reg.text.toString()
            val password = edtPassword_reg.text.toString()

            if (username.isEmpty()) {
                Toast.makeText(this, "Username tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (email.isEmpty()) {
                Toast.makeText(this, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Email tidak valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.length < 6) {
                Toast.makeText(this, "Password minimal 6 karakter", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            registerFirebase(email, password, username)
        }
    }

    private fun registerFirebase(email: String, password: String, username: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val userId = user?.uid

                    val database = FirebaseDatabase.getInstance()
                    val usersRef = database.getReference("users")

                    userId?.let {
                        usersRef.child(it).child("username").setValue(username)
                    }

                    Toast.makeText(this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Registrasi Gagal", Toast.LENGTH_SHORT).show()
                }
            }
    }
    private fun button() {
        kembali = findViewById(R.id.back_reg)
        kembali.setOnClickListener {
            startActivity(Intent(this, LandingActivity::class.java))
        }
        login = findViewById(R.id.txt_login)
        login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}

