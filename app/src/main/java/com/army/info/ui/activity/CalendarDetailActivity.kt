package com.army.info.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.army.info.R
import com.army.info.databinding.ActivityCalendarDetailBinding
import com.army.info.util.SharedManager

class CalendarDetailActivity : AppCompatActivity() {

    private val binding: ActivityCalendarDetailBinding by lazy {
        ActivityCalendarDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val intent = intent
        var year = intent.getStringExtra("selectedYear")
        var month = intent.getStringExtra("selectedMonth")
        var day = intent.getStringExtra("selectedDay")

        val tv_title = findViewById<TextView>(R.id.tv_title)
        val tv_diary = findViewById<TextView>(R.id.tv_diary)
        tv_title.setText(year + "년 " + month + "월 " + day + "일")
        val date = SharedManager.getString(applicationContext, "date", "null")
        Log.d("saved", date)
        if (year + month + day == date) {
            Toast.makeText(applicationContext, "저장된 일기를 불러왔어요.", Toast.LENGTH_SHORT).show()
            tv_diary.setText(SharedManager.getString(applicationContext, date, ""))
        }

        val btn_ok = findViewById<TextView>(R.id.btn_login)
        btn_ok.setOnClickListener {
            if (tv_diary.text.toString().length > 0) {
                val date: String = year + month + day
                SharedManager.putString(applicationContext, "date", date)
                SharedManager.putString(applicationContext, date, tv_diary.text.toString())
                onBackPressed()
                Log.d("saved", date)
                Toast.makeText(applicationContext, "등록완료", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}