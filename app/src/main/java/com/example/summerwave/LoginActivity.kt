package com.example.summerwave

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.summerwave.databinding.ActivityLoginBinding
import com.example.summerwave.databinding.ActivitySignupBinding
import com.example.summerwave.network.RequestToServer

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    val requestToServer = RequestToServer //싱글톤 그대로 가져옴.

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }
}