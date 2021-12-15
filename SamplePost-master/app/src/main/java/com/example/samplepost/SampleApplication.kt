package com.example.samplepost

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SampleApplication:Application() {
    lateinit var api:ApiInterface
    override fun onCreate() {
        super.onCreate()
        api=convertor()
    }
    fun convertor():ApiInterface
    {
        val retrofit=Retrofit.Builder()
            .baseUrl("https://android-kanini-course.cloud/doggeforlife-mobile/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiInterface::class.java)
    }
}