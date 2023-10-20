package com.example.anop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.anop.MainActivity
import com.example.anop.R
import kotlinx.coroutines.MainScope

class SelesaiPomodoroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selesai_pomodoro)

        val btnPomodoroback = findViewById<AppCompatButton>(R.id.btn_share20)

        btnPomodoroback.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}