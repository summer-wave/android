package com.example.summerwave.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestToServer {
//    val client = OkHttpClient.Builder()
//        .addInterceptor(Au)
    var retrofit = Retrofit.Builder()
    .baseUrl("http://dev-sum-api.june.gd/")
//    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    var service: RequestInterface = retrofit.create(RequestInterface::class.java)
}