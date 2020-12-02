package com.example.desafiowebservice.Entities.SpiderMan

data class Res(val data: Data = Data())

data class Data(val offset: Int = 0, var results: ArrayList<Results> = arrayListOf())

data class Results (
    val id : Int,
    val issueNumber : Int,
    val variantDescription : String,
    val title : String,
    val description : String,
    val pageCount : Int,
    val dates : List<Dates>,
    val prices : List<Prices>,
    val thumbnail: Thumbnail
)
data class Prices (

    val type : String,
    val price : Double
)

data class Dates (

    val type : String,
    val date : String
)
data class Thumbnail (

    val path : String,
    val extension : String
)