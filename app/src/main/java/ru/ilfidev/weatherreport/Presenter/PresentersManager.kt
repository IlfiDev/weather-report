package ru.ilfidev.weatherreport.Presenter

class PresentersManager {
    companion object{
        private var city: String = ""

        fun getCity(): String {
            return city
        }
        fun setCity(newCity: String){
            city = newCity
        }
    }
}