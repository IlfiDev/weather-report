package ru.ilfidev.weatherreport.Model

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.ilfidev.weatherreport.BuildConfig
import ru.ilfidev.weatherreport.Model.Retrofit.RetrofitClient
import ru.ilfidev.weatherreport.View.MainContract


class CityWeatherModel(): MainContract, MainContract.Model {
    val APIKey = BuildConfig.API_KEY
    private lateinit var presenter: MainContract.Presenter
    val apiServices = RetrofitClient.getClient().create(RetrofitServices::class.java)
    fun getCurrentWeather(city: String){

        val call = apiServices.getCurrentWeatherList("weather?q=${city}&appid=${APIKey}")
        call.enqueue(object : Callback<WeatherItem>{
            override fun onResponse(call : Call<WeatherItem>, response : Response<WeatherItem>){
                Log.d("Weather", response.body().toString())
                if(response.isSuccessful) {
                    sendCurrentWeather(response.body()!!)
                    Log.d("Weather", response.body().toString())
                }

            }
            override fun onFailure(call : Call<WeatherItem>, t: Throwable){
                Log.e("WeatherError", t.toString() )
            }
        })
    }
    fun getWeatherForTheWeek(city: String){
        val call = apiServices.getFiveDaysWeather("forecast?q=${city}&appid=${APIKey}")
        call.enqueue(object  : Callback<ForecastItem>{
            override fun onResponse(call : Call<ForecastItem>, response : Response<ForecastItem>){
                if(response.isSuccessful){
                    sendForecast(response.body()!!)
                    Log.d("Weather", response.body().toString())
                }

            }
            override fun onFailure(call : Call<ForecastItem>, t: Throwable){
                Log.e("WeatherError", t.toString() )
            }

        })
    }

    fun sendCurrentWeather(data: WeatherItem){
        presenter.getCurrentWeather(data)
    }
    fun sendForecast(data: ForecastItem) {
        presenter.getForecast(data)
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        if(!this::presenter.isInitialized){

            this.presenter = presenter
        }
    }
}