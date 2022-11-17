package ru.ilfidev.weatherreport.Model

import android.os.Build
import android.util.Log
import androidx.lifecycle.lifecycleScope
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback
import ru.ilfidev.weatherreport.BuildConfig
import ru.ilfidev.weatherreport.Model.Retrofit.RetrofitClient
import ru.ilfidev.weatherreport.View.MainContract


class CityWeatherModel(): MainContract, MainContract.Model {
    val APIKey = BuildConfig.API_KEY
    private final val url = "https://api.openweathermap.org/data/2.5/weather?q="
    private lateinit var tempUrl: String
    private lateinit var presenter: MainContract.Presenter
    fun getCurrentWeather(city: String){
        val apiServices = RetrofitClient.getClient().create(RetrofitServices::class.java)
        val call = apiServices.getCurrentWeatherList("weather?q=${city}&appid=" + APIKey)
        var weather = WeatherItem()
        call.enqueue(object : Callback<WeatherItem>{
            override fun onResponse(call : Call<WeatherItem>, response : Response<WeatherItem>){
                sendData(response.body()!!)
                Log.d("Weather", weather.toString())
            }
            override fun onFailure(call : Call<WeatherItem>, t: Throwable){
                Log.e("WeatherError", t.toString() )
            }
        })
    }

    fun sendData(data: WeatherItem){
        presenter.getData(data)
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        if(!this::presenter.isInitialized){

            this.presenter = presenter
        }
    }
}