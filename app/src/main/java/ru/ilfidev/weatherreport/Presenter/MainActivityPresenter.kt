package ru.ilfidev.weatherreport.Presenter

import ru.ilfidev.weatherreport.Model.WeatherItem
import ru.ilfidev.weatherreport.View.MainContract

class MainActivityPresenter(view: MainContract.View, dependencyInjector: DependencyInjector) : MainContract.Presenter {
    private val weatherModel = dependencyInjector.weatherModel()
    private var view: MainContract.View? = view
    override fun upadateWeather() {
        weatherModel.setPresenter(this)
        weatherModel.getCurrentWeather("Tver")
    }

    override fun getData(weatherItem: WeatherItem) {
        val arr = listOf(weatherItem, weatherItem, weatherItem,weatherItem,weatherItem)
        view?.ShowWeather(arr)
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }
}
