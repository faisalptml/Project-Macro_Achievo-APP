package com.example.anop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatButton
import com.example.anop.databinding.ActivityDaftarAktivitasTugasBinding
import com.example.anop.databinding.ActivityPenjadwalanTugasBinding

class Daftar_Aktivitas_Tugas : AppCompatActivity(){

    private lateinit var tBinding: ActivityDaftarAktivitasTugasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tBinding = ActivityDaftarAktivitasTugasBinding.inflate(LayoutInflater.from(this))
        setContentView(tBinding.root)

        val btnBack = findViewById<ImageButton>(R.id.imageButtonBck)

        btnBack.setOnClickListener {
            val intent = Intent(this@Daftar_Aktivitas_Tugas, MainActivity::class.java)
            startActivity(intent)

        }

        val items = listOf<String>("Aktivitas", "Tugas")
        val adapter = ArrayAdapter(this, R.layout.list_dropdown1, items)
        tBinding.dropdownDaftar.setAdapter(adapter)

    }

}