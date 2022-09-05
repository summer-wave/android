package com.example.summerwave.network.data.request

data class RequestSignupData(
    val login_type: String?,
    val email: String,
    val password: String,
    val is_agree_optional_term: Int?,
    val nickname: String?,
    val profile_image_url: String?
)