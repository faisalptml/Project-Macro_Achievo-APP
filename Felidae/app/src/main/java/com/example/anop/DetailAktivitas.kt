package com.example.anop

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class DetailAktivitas : AppCompatActivity(), View.OnClickListener {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_aktivitas)

        val btnAktivitas: Button = findViewById(R.id.kerjakanAktivitas_btn)
        btnAktivitas.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.kerjakanAktivitas_btn -> {
                val intent = Intent(this@DetailAktivitas, Daftar_Aktivitas_Tugas::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}