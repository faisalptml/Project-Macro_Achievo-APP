package com.example.anop

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton

class NotifikasiActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifikasi2)

        val btnNotifikasi3 = findViewById<AppCompatButton>(R.id.notifikasi_btn8)
        btnNotifikasi3.setOnClickListener{
            showCustomDialogBox()
        }
    }

//    @SuppressLint("MissingInflatedId")
//    private fun showCustomAlert() {
//        val dialogView = layoutInflater.inflate(R.layout.activity_notif_pop_up, null)
//        val customDialog = AlertDialog.Builder(this)
//            .setView(dialogView)
//            .show()
//        val btDismiss = dialogView.findViewById<AppCompatButton>(R.id.notifikasi_btn8)
//        btDismiss.setOnClickListener {
//            customDialog.dismiss()
//        }
//    }

    private fun showCustomDialogBox() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_notif_pop_up)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnYes: Button = dialog.findViewById(R.id.btn_start)
        val btnNo : Button = dialog.findViewById(R.id.btn_cancel)

        btnYes.setOnClickListener{
            val intent = Intent(this, BagianIIIPomodoroActivity::class.java)
            startActivity(intent)
        }

        btnNo.setOnClickListener{
            val intent = Intent(this, NotifikasiActivity2::class.java)
            startActivity(intent)
        }
        dialog.show()
    }
}