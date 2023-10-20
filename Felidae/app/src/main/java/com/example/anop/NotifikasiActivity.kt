package com.example.anop

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatButton

class NotifikasiActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifikasi)


            val btnSelanjutnya = findViewById<AppCompatButton>(R.id.selanjutnya_btn)

            btnSelanjutnya.setOnClickListener {
                val intent = Intent(this, MotivasiActivity::class.java)
                startActivity(intent)
            }

        val btnBack = findViewById<ImageButton>(R.id.btn_back)

        btnBack.setOnClickListener {
            val intent = Intent(this, NotifikasiActivity2::class.java)
            startActivity(intent)
        }
    }
}