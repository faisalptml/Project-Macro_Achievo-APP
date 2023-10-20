package com.example.anop

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class NotifPopUp : AppCompatActivity(), View.OnClickListener {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notif_pop_up)

        val btnDoIt: Button = findViewById(R.id.btn_start)
        btnDoIt.setOnClickListener(this)

        val btnDont: Button = findViewById(R.id.btn_cancel)
        btnDont.setOnClickListener(this)
    }

    override fun onClick(p: View) {
        when(p.id){
            R.id.btn_start ->{
                val intent = Intent(this@NotifPopUp, StopwatchIIIPomodoroActivity::class.java)
                startActivities(arrayOf(intent))
            }

            R.id.btn_cancel ->{
                val intent = Intent(this@NotifPopUp, NotifikasiActivity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }
}