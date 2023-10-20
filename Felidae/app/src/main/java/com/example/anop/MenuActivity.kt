package com.example.anop

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MenuActivity : AppCompatActivity(), View.OnClickListener {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_main)

        val btnMenu: Button = findViewById(R.id.btn_mainmenu)
        btnMenu.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_mainmenu -> {
                val intent = Intent(this@MenuActivity, RegisterActivity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}