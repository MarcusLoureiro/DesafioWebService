package com.example.desafiowebservice.Service

import com.example.desafiowebservice.Entities.Hq
import com.example.desafiowebservice.Entities.SpiderMan.Characters
import com.example.desafiowebservice.Entities.SpiderMan.Data
import com.example.desafiowebservice.Entities.SpiderMan.Images
import com.example.desafiowebservice.Entities.SpiderMan.Results
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {


    @GET("characters/1009610/comics?ts=1&apikey=6eb7e8896ec5850c52515a8a23ee97f0&hash=40a3aa568bb269dfad85ae0c4a297181")
    suspend fun getAllResults(): Results

}

val urlApiMarvel = "https://gateway.marvel.com/v1/public/"


val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(urlApiMarvel)
    .build()

val service: Service = retrofit.create(Service::class.java)