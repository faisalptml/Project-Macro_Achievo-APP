package com.example.anop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.anop.R

class StopwatchIIIPomodoroActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch_iiipomodoro)

        val btnFinish: Button = findViewById(R.id.btn_finish)
        btnFinish.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_finish -> {

                val intent = Intent(this@StopwatchIIIPomodoroActivity, CheckIIIPomodoroActivity::class.java)
                startActivity(intent)
            }
        }
    }
}