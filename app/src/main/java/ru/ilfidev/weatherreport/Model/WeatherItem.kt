package ru.ilfidev.weatherreport.Model

import com.google.gson.annotations.SerializedName

data class WeatherItem(
    @SerializedName ("base") val base: String = "",
    @SerializedName ("clouds") val clouds: Clouds = Clouds(-1),
    @SerializedName ("cod") val cod: Int = 0,
    @SerializedName ("coord") val coord: Coord = Coord(-1.1, -1.1),
    @SerializedName ("dt") val dt: Int = -1,
    @SerializedName ("id") val id: Int = -1,
    @SerializedName ("main") val main: Main = Main(0.0,0,0,0,0,0.0,0.0,0.0,),
    @SerializedName ("name") val name: String = "",
    @SerializedName ("snow") val snow: Snow = Snow( 0.0),
    @SerializedName ("sys") val sys: Sys = Sys("", -1, -1),
    @SerializedName ("timezone") val timezone: Int = 0,
    @SerializedName ("visibility") val visibility: Int = 0,
    @SerializedName ("weather") val weather: List<WeatherX> = emptyList(),
    @SerializedName ("wind") val wind: Wind = Wind(-1, -1.1, -1.1)
)