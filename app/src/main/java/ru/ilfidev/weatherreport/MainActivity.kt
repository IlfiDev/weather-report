package ru.ilfidev.weatherreport

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.WARN
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.HttpException
import ru.ilfidev.weatherreport.Model.CityWeatherModel
import ru.ilfidev.weatherreport.Model.Retrofit.RetrofitClient
import ru.ilfidev.weatherreport.Model.RetrofitServices
import ru.ilfidev.weatherreport.View.MainContract
import java.io.IOException

class MainActivity : AppCompatActivity(), MainContract.View {

    var id = 0
    private lateinit var tempUrl: String
    private lateinit var textView: TextView
    private lateinit var plusBtn: Button
    private lateinit var minusBtn: Button
    private var city = "Tver"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.value)
        plusBtn = findViewById(R.id.plusBtn)
        minusBtn = findViewById(R.id.minusBtn)
        textView.setText("" + id)
        var cityWeather = CityWeatherModel("")
        val PERMISSION_ALL = 1
        val PERMISSIONS = arrayOf(android.Manifest.permission.INTERNET)
        if (!hasPermissions(this, *PERMISSIONS)){
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL)

        }
        plusBtn.setOnClickListener {
            cityWeather.getWeather()
        }
        minusBtn.setOnClickListener {
            textView.setText("" + --id)
        }
    }
    suspend fun getWeather(){
//        val response = RetrofitClient.api.getCurrentWeatherList("weather?q=Tver&appid=da04bab5b9ea80aac099ed157b930425")
//
//        if(response.isSuccessful && response.body() != null){
//            Log.d("COCK", response.body().toString())
//        }
    }
    fun hasPermissions(context: Context, vararg  permissions: String): Boolean {
        if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null){
            for (permission in permissions){
                if(ActivityCompat.checkSelfPermission(context, permission.toString()) != PackageManager.PERMISSION_GRANTED){
                    return false
                }
            }
        }
        return true
    }

    override fun ShowWeather() {
        TODO("Not yet implemented")
    }
}