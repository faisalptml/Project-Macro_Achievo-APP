package com.example.anop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class TambahTugasSuccess : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_tugas_success)

        val btnKerjakan: Button = findViewById(R.id.btn_kerjakan)
        btnKerjakan.setOnClickListener(this)

        val btnLihat: Button = findViewById(R.id.btn_lihat)
        btnLihat.setOnClickListener(this)

        val arrowBack: ImageButton = findViewById(R.id.imageButtonBck)
        arrowBack.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_kerjakan -> {
                val intent = Intent(this@TambahTugasSuccess, BagianIIIPomodoroActivity::class.java)
                startActivities(arrayOf(intent))
            }

            R.id.btn_lihat -> {
                val intent = Intent(this@TambahTugasSuccess, DetailTugas::class.java)
                startActivities(arrayOf(intent))
            }

            R.id.imageButtonBck -> {
                val intent = Intent(this@TambahTugasSuccess, MainActivity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}