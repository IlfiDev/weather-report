package ru.ilfidev.weatherreport.View

interface MainContract {
    interface View {
        fun ShowWeather()
    }

    interface Presenter {
        fun onButtonClicked()
    }

    interface Model {
        fun loadWeather()
    }
}