package ru.ilfidev.weatherreport.Model

data class Weather(var temp: Float,
                   var tempFeelsLike: Float,
                   var pressure: Float,
                   var description: String,
                   var dateTxt: String)