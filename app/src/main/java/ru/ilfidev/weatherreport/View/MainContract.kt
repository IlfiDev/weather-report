package ru.ilfidev.weatherreport.View

import ru.ilfidev.weatherreport.Model.ForecastItem
import ru.ilfidev.weatherreport.Model.WeatherItem

interface MainContract {
    interface View : BaseView<Presenter>{
        fun ShowWeather(weatherList : ForecastItem)
    }

    interface Presenter : BasePresenter {
        fun upadateWeather()
        fun getCurrentWeather(weatherItem: WeatherItem)
        fun getForecast(weatherItem: ForecastItem)
    }
    interface  Model{
        fun setPresenter(presenter: MainContract.Presenter)

    }

}
interface BasePresenter {
    fun onDestroy()
}
interface BaseView<T> {
    fun setPresenter(presenter : T)
}