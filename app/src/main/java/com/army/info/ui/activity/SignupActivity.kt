package com.army.info.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.army.info.databinding.ActivitySignupBinding
import com.army.info.util.SharedManager

class SignupActivity : AppCompatActivity() {

    private val binding: ActivitySignupBinding by lazy {
        ActivitySignupBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            val email = binding.etId.text.toString()
            val password = binding.etPw.text.toString()
            val name = binding.etName.text.toString()
            val sex = binding.rgSex.checkedRadioButtonId

            if (email.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty() && sex != -1) {
                val sexString = findViewById<RadioButton>(sex).text.toString()
                signUp(email, password, name, sexString)

            } else {
                Toast.makeText(this, "빈칸이 있습니다!", Toast.LENGTH_LONG).show()
            }
        }
    }

    // 회원가입 함수
    fun signUp(email: String, password: String, name: String, sex: String) {

        SharedManager.putString(this, "email", email)
        SharedManager.putString(this, "pw", password)
        SharedManager.putString(this, "name", name)

        startActivity(Intent(this, LoginActivity::class.java))
        Toast.makeText(this, "$name 님 환영합니다.", Toast.LENGTH_LONG).show()

    }

}