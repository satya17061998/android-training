package com.example.samplepost.data

data class User(val id:Int,
val email:String,val password:String,val token:String,val memberSince:Long)
data class UserReq(val email: String,val password: String)