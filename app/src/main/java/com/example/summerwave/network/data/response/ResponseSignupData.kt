package com.example.summerwave.network.data.response

data class ResponseSignupData(
    val status: Boolean,
    val code: Int,
    val message: String?,
    val data: JwtData?
)

data class JwtData(
    val jwt: String?
)

