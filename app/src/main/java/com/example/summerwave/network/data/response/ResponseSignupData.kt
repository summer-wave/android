package com.example.summerwave.network.data.response

data class ResponseSignupData(
    val status: Boolean,
    val code: Int,
    val message: String?,
    val data: SomeData?
)

data class SomeData(
    val status: Boolean,
    val code: Int,
    val message: String?,
    val data: UserId?
)

data class UserId(
    val user_id: Int
)
