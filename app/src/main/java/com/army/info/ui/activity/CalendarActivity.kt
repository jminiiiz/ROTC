package com.army.info.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.army.info.R
import com.army.info.databinding.ActivityCalendarBinding
import com.prolificinteractive.materialcalendarview.MaterialCalendarView

class CalendarActivity : AppCompatActivity() {

    private val binding: ActivityCalendarBinding by lazy {
        ActivityCalendarBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val materialCalendarView = findViewById<MaterialCalendarView>(R.id.calendarView)
        materialCalendarView.setOnDateChangedListener { widget, date, selected ->
            Toast.makeText(
                applicationContext,
                date.year.toString() + "/" + date.month + "/" + date.day + "",
                Toast.LENGTH_SHORT
            ).show()
            val intent = Intent(applicationContext, CalendarDetailActivity::class.java)
            intent.putExtra("selectedYear", date.year.toString() + "")
            intent.putExtra("selectedMonth", date.month.toString() + "")
            intent.putExtra("selectedDay", date.day.toString() + "")
            startActivity(intent)
        }
    }
}