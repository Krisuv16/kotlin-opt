package com.example.krisuvbohara_mapd711_optional_assignment.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//config class to setup base file to configure URL
object Config {

    //setting up base url
    private const val BASE_URL = "https://dummyjson.com/"

    fun getRetroFitInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}