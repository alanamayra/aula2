package com.example.exerc2


import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity


class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
    override fun onPause() {
        super.onPause()

        // Limpar informações de login
        val sharedPreferences = getSharedPreferences("login_info", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}