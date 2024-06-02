package com.army.info.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.army.info.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.menu1.setOnClickListener {
            startActivity(Intent(applicationContext, MenuActivity::class.java))
        }
        binding.menu2.setOnClickListener {
            startActivity(Intent(applicationContext, CalendarActivity::class.java))
        }
    }
}
