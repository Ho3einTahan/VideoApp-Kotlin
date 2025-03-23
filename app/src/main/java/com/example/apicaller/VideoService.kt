package com.example.apicaller

import retrofit2.Call
import retrofit2.http.GET

interface VideoService {

    @GET("mostviewedvideos")
    fun getVideoList(): Call<Movies>
}