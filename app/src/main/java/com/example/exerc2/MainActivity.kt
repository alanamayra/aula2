package com.example.exerc2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val usernameEditText = findViewById<EditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)

        val fixedPassword = "123" // Senha fixa para verificação

        // Verificar e preencher informações de login
        val sharedPreferences = getSharedPreferences("login_info", MODE_PRIVATE)
        val savedUsername = sharedPreferences.getString("username", "")
        usernameEditText.setText(savedUsername)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (password == fixedPassword) {
                val intent = Intent(this, Home::class.java)
                startActivity(intent)

                // Salvar informações de login
                val editor = sharedPreferences.edit()
                editor.putString("username", username)
                editor.apply()
            } else {
                Toast.makeText(this, "Credenciais inválidas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}