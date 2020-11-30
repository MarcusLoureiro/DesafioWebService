package com.example.desafiowebservice.Entities.SpiderMan

data class Res(val data: Data)

data class Data(val offset: Int, var results: ArrayList<Results>)

data class Results (
    val id : Int,
    val title : String,
    val description : String,
    val pageCount : Int,
    val dates : List<Dates>,
    val prices : List<Prices>,
    val images : List<Images>,
)
data class Images (
    val path : String,
    val extension : String
)

data class Prices (

    val type : String,
    val price : Double
)

data class Dates (

    val type : String,
    val date : String
)