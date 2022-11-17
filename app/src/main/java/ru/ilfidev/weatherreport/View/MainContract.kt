package ru.ilfidev.weatherreport.View

import ru.ilfidev.weatherreport.Model.WeatherItem

interface MainContract {
    interface View : BaseView<Presenter>{
        fun ShowWeather(weatherList : List<WeatherItem>)
    }

    interface Presenter : BasePresenter {
        fun upadateWeather()
        fun getData(weatherItem: WeatherItem)
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