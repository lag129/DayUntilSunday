package com.example.dayuntilsunday

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.time.*
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalAdjusters

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val today = LocalDate.now()

        val sunday = today.with(TemporalAdjusters.next(DayOfWeek.SUNDAY))

        val daysUntilSunday = ChronoUnit.DAYS.between(today, sunday)

        val result = "今日から日曜日まであと${daysUntilSunday}日あります。"
        //println(result)
        val tvMain = findViewById<TextView>(R.id.tvMain)
        tvMain.setText(result)
    }
}