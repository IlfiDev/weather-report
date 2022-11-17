package ru.ilfidev.weatherreport

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.WARN
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.HttpException
import ru.ilfidev.weatherreport.Model.CityWeatherModel
import ru.ilfidev.weatherreport.Model.Retrofit.RetrofitClient
import ru.ilfidev.weatherreport.Model.RetrofitServices
import ru.ilfidev.weatherreport.Model.WeatherItem
import ru.ilfidev.weatherreport.Presenter.DependencyInjectionImpl
import ru.ilfidev.weatherreport.Presenter.MainActivityPresenter
import ru.ilfidev.weatherreport.View.MainContract
import ru.ilfidev.weatherreport.View.TestFragment
import ru.ilfidev.weatherreport.View.TimeWeatherRecyclerAdapter
import java.io.IOException

class MainActivity : AppCompatActivity(), MainContract.View {

    var id = 0
    private lateinit var tempUrl: String
    private lateinit var textView: TextView
    private lateinit var plusBtn: Button
    private lateinit var minusBtn: Button
    private lateinit var linearLayout: LinearLayout
    private var city = "Tver"
    private lateinit var presenter: MainContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setPresenter(MainActivityPresenter(this, DependencyInjectionImpl()))
        presenter.upadateWeather()
    }

    override fun ShowWeather(weatherList : List<WeatherItem>) {
        val recyclerView = findViewById<RecyclerView>(R.id.time_weather_recycle_view)
        val horizontalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = horizontalLayoutManager
        val adapter = TimeWeatherRecyclerAdapter(this,weatherList)
        recyclerView.adapter = adapter
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }
}


