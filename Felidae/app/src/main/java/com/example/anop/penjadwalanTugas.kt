package com.example.anop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import com.example.anop.databinding.ActivityPenjadwalanTugasBinding
import com.example.anop.databinding.ActivityRegisterBinding

class penjadwalanTugas : AppCompatActivity(), View.OnClickListener {

    private lateinit var tBinding: ActivityPenjadwalanTugasBinding
    private lateinit var tJudul: EditText
    private lateinit var tDesc: EditText
    private lateinit var tKesulitan: EditText
    private lateinit var tKategori: EditText
    private lateinit var tDeadline: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tBinding = ActivityPenjadwalanTugasBinding.inflate(LayoutInflater.from(this))
        setContentView(tBinding.root)

        val btnPindah: Button = findViewById(R.id.btn_simpan)
        btnPindah.setOnClickListener(this)

        val items = listOf<String>("Sangat Mudah", "Mudah", "Biasa Saja", "Sulit", "Sangat Sulit")
        val adapter = ArrayAdapter(this, R.layout.list_dropdown1, items)
        tBinding.dropdownKesulitan.setAdapter(adapter)

        val isi = listOf<String>("Pilihan Ganda", "Isian", "Essay", "Makalah", "Presentasi", "Laporan Praktikum", "Review Jurnal"
            , "Proyek", "Skripsi", "Lainnya")
        val contact = ArrayAdapter(this, R.layout.list_dropdown1, isi)
        tBinding.dropdownJob.setAdapter(contact)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_simpan ->{
                val intent = Intent(this@penjadwalanTugas, TambahTugasSuccess::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}