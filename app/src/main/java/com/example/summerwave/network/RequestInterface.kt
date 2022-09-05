package com.example.summerwave.network

import com.example.summerwave.network.data.request.RequestLoginData
import com.example.summerwave.network.data.request.RequestSignupData
import com.example.summerwave.network.data.response.ResponseLoginData
import com.example.summerwave.network.data.response.ResponseSignupData
import retrofit2.Call
import retrofit2.http.*

interface RequestInterface {
    /* 계정 */
    // 회원가입
    @POST("users/account/signup")
    fun requestSignup(
        @Body body : RequestSignupData
    ) : Call<ResponseSignupData>
    // 로그인
    @POST("users/account/signin")
    fun requsetLogin(
        @Body body : RequestLoginData
    ) : Call<ResponseLoginData>
}