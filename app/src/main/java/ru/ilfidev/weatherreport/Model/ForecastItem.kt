package ru.ilfidev.weatherreport.Model

import com.google.gson.annotations.SerializedName

data class ForecastItem(
    @SerializedName ("list") val list: List<WeatherItem>
)

