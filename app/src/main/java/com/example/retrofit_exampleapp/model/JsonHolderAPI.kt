package com.example.retrofit_exampleapp.model

import retrofit2.http.GET
import retrofit2.Call

interface JsonHolderAPI {
    @GET("comments")
    fun getComments():Call<List<Comments>>
}