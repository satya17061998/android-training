package com.example.samplepost


import com.example.samplepost.data.User
import com.example.samplepost.data.UserReq
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST("login")
    fun postData(@Body user:UserReq): Call<User>

}