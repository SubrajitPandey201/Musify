package com.example.musify

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterFace {

    @Headers("X-RapidAPI-Key: 231ead188fmshc5d18a650af3d62p11f93bjsn48c13f3235b4," , "X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com")
    @GET("Search")
    fun getData(@Query("q") query: String) : Call<List<MusicData>>
}