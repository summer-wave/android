package com.example.summerwave.network.data.request

data class RequestSignupData(
    val userObj: AnyData
)

data class AnyData(
    val email: String,
    val login_type: String?,
    val password: String,
//    val is_agree_optional_term:
)
