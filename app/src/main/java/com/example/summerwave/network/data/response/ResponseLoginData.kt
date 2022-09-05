package com.example.summerwave.network.data.response

data class ResponseLoginData(
    val status: Boolean,
    val code : Int,
    val message : String?,
    val data : LoginData?
)

data class LoginData(
    val jwt : String?
)
