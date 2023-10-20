package com.example.anop

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.anop.databinding.ActivityProfileBinding
import com.example.anop.databinding.ActivityRegisterBinding
import java.util.Vector

class ProfileActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var etEmail: EditText
    private lateinit var etStatus: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


        etEmail = findViewById(R.id.email_edt)
        etStatus = findViewById(R.id.status_edt)

        val btnEdit: Button = findViewById(R.id.btn_profil)
        btnEdit.setOnClickListener(this)

        val btnBack: ImageView = findViewById(R.id.btn_back)
        btnEdit.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_profil -> {
                val intent = Intent(this@ProfileActivity, DetailTugas::class.java)
//                intent.putExtras(bundle)
                startActivities(arrayOf(intent))
            }

            R.id.btn_back -> {
                val intent = Intent(this@ProfileActivity, LoginActivity::class.java)
//                intent.putExtras(bundle)
                startActivities(arrayOf(intent))
            }

        }
    }
}