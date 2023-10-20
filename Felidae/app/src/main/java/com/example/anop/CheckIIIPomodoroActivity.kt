package com.example.anop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class CheckIIIPomodoroActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_iiipomodoro)

        val btnNext: Button = findViewById(R.id.btn_next)
        btnNext.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_next -> {

                val intent = Intent(this@CheckIIIPomodoroActivity, SelesaiPomodoroActivity::class.java)
                startActivity(intent)
            }
        }
    }
}