package ru.ilfidev.weatherreport.Model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface RetrofitServices {
    @GET
    fun getCurrentWeatherList(@Url url: String): Call<WeatherItem>

    @GET
    fun getFiveDaysWeather(@Url url: String): Call<ForecastItem>

}