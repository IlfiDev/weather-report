package ru.ilfidev.weatherreport.Presenter

import ru.ilfidev.weatherreport.Model.CityWeatherModel
import ru.ilfidev.weatherreport.Model.WeatherItem

interface DependencyInjector {
    fun weatherModel() : CityWeatherModel
}

class DependencyInjectionImpl : DependencyInjector{
    override fun weatherModel(): CityWeatherModel {
        return CityWeatherModel()
    }

}