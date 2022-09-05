package com.example.summerwave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.summerwave.databinding.ActivityLoginBinding
import com.example.summerwave.databinding.ActivitySignupBinding
import com.example.summerwave.network.RequestToServer
import com.example.summerwave.network.data.request.RequestLoginData
import com.example.summerwave.network.data.response.ResponseLoginData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    val requestToServer = RequestToServer //싱글톤 그대로 가져옴.

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnLogin.setOnClickListener {
            if (binding.etEmail.text.isNullOrBlank() || binding.etPassword.text.isNullOrBlank() ) {
                Toast.makeText(this, "이메일과 비밀번호를 다시 확인해주세요.", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "로그인을 해보자구", Toast.LENGTH_SHORT).show()

                // 로그인 요청
                requestToServer.service.requsetLogin(
                    RequestLoginData(
                        login_type = "summer_wave",
                        email = binding.etEmail.text.toString(),
                        password = binding.etPassword.text.toString()
                    )
                ).enqueue(object : Callback<ResponseLoginData> {
                    override fun onResponse(
                        call: Call<ResponseLoginData>,
                        response: Response<ResponseLoginData>
                    ) {
                        if (response.isSuccessful) {
                            Log.d("로그인 통신 성공", response.toString())
                            Log.d("로그인 통신 성공 @@", response.body().toString())
                            Toast.makeText(this@LoginActivity, "로그인 완료", Toast.LENGTH_SHORT)
                                .show()
                            val intent = Intent(this@LoginActivity, TestActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                        else {
                            Toast.makeText(this@LoginActivity, "로그인 실패", Toast.LENGTH_SHORT)
                                .show()
                            when (response.code()) {
                                404 -> Log.d("실패", response.message())
                            }
                        }
                    }

                    override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                        Log.d("로그인 통신 실패", t.toString())
                        Toast.makeText(this@LoginActivity, "로그인 통신 실패", Toast.LENGTH_SHORT)
                            .show()
                    }

                })
            }
        }


    }
}