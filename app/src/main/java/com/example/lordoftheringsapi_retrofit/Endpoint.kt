package com.example.lordoftheringsapi_retrofit

import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {

    @GET("book")
    fun getPosts() : Call<Posts>

}