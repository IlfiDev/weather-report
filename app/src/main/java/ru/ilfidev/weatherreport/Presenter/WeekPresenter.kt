package ru.ilfidev.weatherreport.Presenter

import ru.ilfidev.weatherreport.Model.ForecastItem
import ru.ilfidev.weatherreport.Model.WeatherItem
import ru.ilfidev.weatherreport.View.MainContract

class WeekPresenter (view: MainContract.View, dependencyInjector: DependencyInjector): MainContract.Presenter {
    private val weatherModel = dependencyInjector.weatherModel()
    private var view: MainContract.View? = view
    private lateinit var weatherList: ForecastItem
    private lateinit var city: String
    override fun updateWeatherForecast() {
        weatherModel.setPresenter(this)
        weatherModel.getWeatherForTheWeek(city)
    }

    override fun updateCurrentWeather() {
        TODO("Not yet implemented")
    }

    override fun getCurrentWeather(weatherItem: WeatherItem) {
        TODO("Not yet implemented")
    }

    override fun getForecast(weatherItem: ForecastItem) {
        weatherList = weatherItem
        view?.showWeather(weatherItem)
    }

    override fun setCity(city: String) {
        this.city = city
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }
}