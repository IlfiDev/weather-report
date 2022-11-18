package ru.ilfidev.weatherreport.Presenter

import ru.ilfidev.weatherreport.Model.ForecastItem
import ru.ilfidev.weatherreport.Model.WeatherItem
import ru.ilfidev.weatherreport.View.MainContract

class ChooseCityPresenter(view: MainContract.View, dependencyInjector: DependencyInjector): MainContract.Presenter {
    val view = view
    val weatherModel = dependencyInjector.weatherModel()
    private lateinit var citiesList: List<String>
    private lateinit var city: String
    fun checkCity(city: String){

    }
    override fun updateWeatherForecast() {
        TODO("Not yet implemented")
    }

    override fun updateCurrentWeather() {
        weatherModel.setPresenter(this)
        weatherModel.getCurrentWeather(city)
    }

    override fun getCurrentWeather(weatherItem: WeatherItem) {
        PresentersManager.setCity(city)
        view?.showCurrentWeather(weatherItem)
    }

    override fun getForecast(weatherItem: ForecastItem) {
        TODO("Not yet implemented")
    }

    override fun setCity(city: String) {
        this.city = city
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }

}