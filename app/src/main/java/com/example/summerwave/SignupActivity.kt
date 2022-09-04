package com.example.summerwave

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.summerwave.databinding.ActivitySignupBinding
import com.example.summerwave.network.RequestToServer
import com.example.summerwave.network.data.request.AnyData
import com.example.summerwave.network.data.request.RequestSignupData
import com.example.summerwave.network.data.response.ResponseSignupData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    val requestToServer = RequestToServer //싱글톤 그대로 가져옴.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnSignup.setOnClickListener() {
            if (binding.etEmail.text.isNullOrBlank() || binding.etPassword.text.isNullOrBlank() ) {
                Toast.makeText(this, "이메일과 비밀번호를 다시 확인해주세요.", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "회원가입을 해보자구", Toast.LENGTH_SHORT).show()

                // 회원가입 요청
                requestToServer.service.requestSignup(
                    RequestSignupData(
                        userObj = AnyData(
                            binding.etEmail.text.toString(),
                            "summer_wave",
                            binding.etPassword.text.toString())
                    )
                ).enqueue(object : Callback<ResponseSignupData> {
                    override fun onResponse(
                        call: Call<ResponseSignupData>,
                        response: Response<ResponseSignupData>
                    ) {
                        // 통신 성공
                        if (response.isSuccessful) {
                            Log.d("성공", response.toString())
                            Log.d("성공 @@", response.body().toString())
                            Toast.makeText(this@SignupActivity, "회원가입 완료", Toast.LENGTH_SHORT)
                                .show()
                            val intent = Intent(this@SignupActivity, LoginActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this@SignupActivity, "회원가입 실패", Toast.LENGTH_SHORT)
                                .show()
                            when (response.code()) {
                                404 -> Log.d("실패", response.message())
                            }
                        }
                    }
                    // 통신 실패
                    override fun onFailure(call: Call<ResponseSignupData>, t: Throwable) {
                        Toast.makeText(this@SignupActivity, "회원가입 통신 실패.", Toast.LENGTH_SHORT).show()
                        Log.d("실패", t.message.toString())
                    }
                })
            }
        }
    }

}