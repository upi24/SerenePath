package com.example.project.account

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.project.R
import com.example.project.awal.LoginActivity
import com.example.project.home.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AccountActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var akun: ImageView
    private lateinit var switchButton: Switch
    private lateinit var sharedPreferences: SharedPreferences

    companion object {
        private const val KEY_THEME = "theme_preference"
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        switchButton = findViewById(R.id.switchButton)
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        setThemeFromPreference()

        switchButton.setOnCheckedChangeListener { _, isChecked ->
            saveThemePreference(isChecked)
            applyTheme(isChecked)
        }

        switchButton.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                switchButton.isChecked = !switchButton.isChecked
            }
            false
        }

        val keluar: View = findViewById(R.id.btn_logout)

        auth = FirebaseAuth.getInstance()

        val currentUser: FirebaseUser? = auth.currentUser
        if (currentUser != null) {
            val userEmail = currentUser.email
            val userNameTextView: TextView = findViewById(R.id.userNameTextView)
            userNameTextView.text = "$userEmail"
        }

        akun = findViewById(R.id.home_account)
        akun.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
        keluar.setOnClickListener {
            logout()
        }
    }

    private fun setThemeFromPreference() {
        val isDarkMode = sharedPreferences.getBoolean(KEY_THEME, false)
        applyTheme(isDarkMode)
        switchButton.isChecked = isDarkMode
    }

    private fun applyTheme(isDarkMode: Boolean) {
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        delegate.applyDayNight()
    }

    private fun saveThemePreference(isDarkMode: Boolean) {
        sharedPreferences.edit().putBoolean(KEY_THEME, isDarkMode).apply()
    }

    private fun logout() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirm Logout")
            .setMessage("Are you sure you want to Logout?")
            .setPositiveButton(android.R.string.yes) { dialog, which ->
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            .setNegativeButton(android.R.string.no) { dialog, which ->
                dialog.dismiss()
            }
            .show()
    }

    override fun onDestroy() {
        saveThemePreference(switchButton.isChecked)
        super.onDestroy()
    }
}