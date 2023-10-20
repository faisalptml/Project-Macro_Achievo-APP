package com.example.anop

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

class StatistikActivity : AppCompatActivity() {

    lateinit var barChart: BarChart
    lateinit var barData: BarData
    lateinit var barDataSet: BarDataSet
    lateinit var barEntriesList: ArrayList<BarEntry>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistik)

        val btnSelesai = findViewById<AppCompatButton>(R.id.selesai_btn)

        btnSelesai.setOnClickListener {
            val intent = Intent(this, SelesaiActivity::class.java)
            startActivity(intent)
        }

        val btnTerlambat = findViewById<AppCompatButton>(R.id.terlambat_btn)

        btnTerlambat.setOnClickListener {
            val intent = Intent(this, TerlambatActivity::class.java)
            startActivity(intent)
        }

        val btnAntrian = findViewById<AppCompatButton>(R.id.antrian_btn)

        btnAntrian.setOnClickListener {
            val intent = Intent(this, DalamAntrianActivity2::class.java)
            startActivity(intent)
        }

        val btnSedangDikerjakan = findViewById<AppCompatButton>(R.id.dikerjakan_btn)

        btnSedangDikerjakan.setOnClickListener {
            val intent = Intent(this, SedangDikerjakanActivity::class.java)
            startActivity(intent)
        }

        val btnBack = findViewById<ImageButton>(R.id.imageButtonBck)

        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        barChart = findViewById(R.id.idBarChart)

        getBarChartData()

        barDataSet = BarDataSet(barEntriesList, "Bar Chart Data")
        barDataSet.color = Color.parseColor("#FF5733")
        barData = BarData(barDataSet)

        barChart.data = barData
        barDataSet.valueTextColor = Color.BLACK
        barDataSet.valueTextSize = 16f
        barChart.description.isEnabled = false

        val xAxis = barChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.granularity = 1f
        xAxis.isGranularityEnabled = true
        xAxis.labelCount = barEntriesList.size
        xAxis.valueFormatter = IndexAxisValueFormatter(getXAxisLabels())
    }

    private fun getBarChartData() {
        barEntriesList = ArrayList()

        barEntriesList.add(BarEntry(1f, 5f))
        barEntriesList.add(BarEntry(2f, 4f))
        barEntriesList.add(BarEntry(3f, 3f))
        barEntriesList.add(BarEntry(4f, 4f))
        barEntriesList.add(BarEntry(5f, 5f))
        barEntriesList.add(BarEntry(6f, 6f))
        barEntriesList.add(BarEntry(7f, 7f))
    }

    private fun getXAxisLabels(): List<String> {
        return listOf("", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu")
    }

    }


