package ru.ilfidev.weatherreport.Model.Retrofit

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.ilfidev.weatherreport.Model.RetrofitServices

object RetrofitClient {
    var retrofit : Retrofit? = null

    fun getClient(): Retrofit{
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

}