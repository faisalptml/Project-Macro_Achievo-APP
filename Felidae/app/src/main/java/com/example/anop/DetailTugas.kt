package com.example.anop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class DetailTugas : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tugas)

        val btnTugas: Button = findViewById(R.id.kerjakanTugas_btn)
        btnTugas.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.kerjakanTugas_btn -> {
                val intent = Intent(this@DetailTugas, Daftar_Aktivitas_Tugas::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}