package com.army.info.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.army.info.databinding.ActivityMainBinding
import com.army.info.databinding.ActivityMenu1Binding
import com.google.android.material.navigation.NavigationBarView

class MenuActivity : AppCompatActivity() {
    private val binding: ActivityMenu1Binding by lazy {
        ActivityMenu1Binding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.menu1.setOnClickListener {
            val intent = Intent(applicationContext, TestListActivity::class.java)
            intent.putExtra("category", 1)
            startActivity(intent)
        }
        binding.menu5.setOnClickListener {
            val intent = Intent(applicationContext, TestListActivity::class.java)
            intent.putExtra("category", 5)
            startActivity(intent)
        }
        binding.menu8.setOnClickListener {
            val intent = Intent(applicationContext, TestListActivity::class.java)
            intent.putExtra("category", 8)
            startActivity(intent)
        }
        binding.menu11.setOnClickListener {
            val intent = Intent(applicationContext, TestListActivity::class.java)
            intent.putExtra("category", 11)
            startActivity(intent)
        }

    }
}
