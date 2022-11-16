package ru.ilfidev.weatherreport.Model

import retrofit2.Response
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface RetrofitServices {
    @GET()
    fun getCurrentWeatherList(@Url url: String): Call<WeatherItem>
}