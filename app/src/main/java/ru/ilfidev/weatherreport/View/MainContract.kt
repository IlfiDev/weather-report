package ru.ilfidev.weatherreport.View

import ru.ilfidev.weatherreport.Model.ForecastItem
import ru.ilfidev.weatherreport.Model.WeatherItem

interface MainContract {
    interface View : BaseView<Presenter>{
        fun showWeather(weatherList : ForecastItem)
        fun showCurrentWeather(weatherItem: WeatherItem)
        fun setCity(city: String)
    }

    interface Presenter : BasePresenter {
        fun updateWeatherForecast()
        fun updateCurrentWeather()
        fun getCurrentWeather(weatherItem: WeatherItem)
        fun getForecast(weatherItem: ForecastItem)
        fun setCity(city: String)
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