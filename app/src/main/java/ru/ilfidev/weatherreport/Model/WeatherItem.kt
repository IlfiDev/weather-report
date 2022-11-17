package ru.ilfidev.weatherreport.Model

data class WeatherItem(
    val base: String = "",
    val clouds: Clouds = Clouds(-1),
    val cod: Int = 0,
    val coord: Coord = Coord(-1.1, -1.1),
    val dt: Int = -1,
    val id: Int = -1,
    val main: Main = Main(0.0,0,0,0,0,0.0,0.0,0.0,),
    val name: String = "",
    val snow: Snow = Snow( 0.0),
    val sys: Sys = Sys("", -1, -1),
    val timezone: Int = 0,
    val visibility: Int = 0,
    val weather: List<WeatherX> = emptyList(),
    val wind: Wind = Wind(-1, -1.1, -1.1)
)