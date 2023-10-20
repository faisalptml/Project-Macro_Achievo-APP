package com.example.anop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class BagianIIIPomodoroActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bagian_iiipomodoro)

        val btnStart: Button = findViewById(R.id.btn_start)
        btnStart.setOnClickListener(this)

        val btnCancel: Button = findViewById(R.id.btn_cancel)
        btnCancel.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_start -> {

                val intent = Intent(this@BagianIIIPomodoroActivity, StopwatchIIIPomodoroActivity::class.java)
                startActivity(intent)
            }

            R.id.btn_cancel -> {

                val intent = Intent(this@BagianIIIPomodoroActivity, NotifikasiActivity::class.java)
                startActivity(intent)
            }
        }
    }
}