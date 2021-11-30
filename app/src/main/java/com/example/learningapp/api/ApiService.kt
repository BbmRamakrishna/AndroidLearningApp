package com.example.learningapp.api

import com.example.learningapp.models.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUsers(): Call<MutableList<UserResponse>>
}