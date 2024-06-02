package com.army.info.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.army.info.databinding.ActivityLoginBinding
import com.army.info.util.SharedManager

class LoginActivity : AppCompatActivity() {

    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val emailSaved = SharedManager.getString(this, "email", "")
        val pwSaved = SharedManager.getString(this, "pw", "")

        if (emailSaved.isNotEmpty()) binding.etUsername.setText(emailSaved)
        if (pwSaved.isNotEmpty()) binding.etPassword.setText(pwSaved)

        binding.btnLogin.setOnClickListener {
            val email = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            signIn(email, password)
        }

        // "회원가입하기" 클릭하면 SignupActivity로 이동
        binding.tvSignUpLink.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

    }

    fun signIn(email: String, password: String) {

        //로그인에 성공한 경우 메인 화면으로 이동
        SharedManager.putString(this, "email", email)
        SharedManager.putString(this, "pw", password)

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)


    }

}