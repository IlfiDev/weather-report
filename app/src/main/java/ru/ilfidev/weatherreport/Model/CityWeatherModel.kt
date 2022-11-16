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


class CityWeatherModel(city : String): MainContract.Model {
    private var city = city
    val APIKey = BuildConfig.API_KEY
    private final val url = "https://api.openweathermap.org/data/2.5/weather?q="
    private lateinit var tempUrl: String

    /*fun getWeatherJSON(){
        //val queue = Volley.newRequestQueue( )
        //tempUrl = url + "?q=" + city + "&appid=" + APIKey
        //val stringRequest = StringRequest(
            Request.Method.POST, tempUrl,
            { response ->
                // Display the first 500 characters of the response string.
                Log.d("response", response)
                val jsonResponse = JSONObject(response)
                val jsonArray = jsonResponse.getJSONArray("weather")
                val jsonObjectWeather = jsonArray.getJSONObject(0)
                var discription
            },
            { Log.d("ERROR", "RERRESIE")})
        queue.add(stringRequest)
    }*/

    fun getWeather(){
        val apiServices = RetrofitClient.getClient().create(RetrofitServices::class.java)
        var call = apiServices.getCurrentWeatherList("weather?q=Tver&appid=" + APIKey)
        call.enqueue(object : Callback<WeatherItem>{
            override fun onResponse(call : Call<WeatherItem>, response : Response<WeatherItem>){
                var weather = response.body()
                Log.d("Weather", weather.toString())
            }
            override fun onFailure(call : Call<WeatherItem>, t: Throwable){
                Log.e("WeatherError", t.toString() )
            }
        })
    }

    override fun loadWeather() {
        TODO("Not yet implemented")
    }
}