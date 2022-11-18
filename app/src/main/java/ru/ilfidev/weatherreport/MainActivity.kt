package ru.ilfidev.weatherreport

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.ilfidev.weatherreport.Model.ForecastItem
import ru.ilfidev.weatherreport.Model.WeatherItem
import ru.ilfidev.weatherreport.Presenter.DependencyInjectionImpl
import ru.ilfidev.weatherreport.Presenter.MainActivityPresenter
import ru.ilfidev.weatherreport.Presenter.PresentersManager
import ru.ilfidev.weatherreport.View.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var currentWeatherImage: ImageView
    private lateinit var presenter: MainContract.Presenter
    private lateinit var fiveDaysTextButton: Button
    private lateinit var chooseCityButton: Button
    private lateinit var cityName:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSupportActionBar()?.hide()

        fiveDaysTextButton = findViewById(R.id.five_days_text_id)
        fiveDaysTextButton.setText("Next 5 days")
        fiveDaysTextButton.setOnClickListener(object:  View.OnClickListener {
            override fun onClick(view:View){
                val intent = Intent(view.context, WeekActivity::class.java)
                startActivity(intent)
            }
        })
        chooseCityButton = findViewById(R.id.switch_to_city_activity_id)
        chooseCityButton.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view:View){
                val intent = Intent(view.context, ChooseCityActivity::class.java)
                startActivity(intent)
            }
        })


        setPresenter(MainActivityPresenter(this, DependencyInjectionImpl()))
        val intent = Intent(this, ChooseCityActivity::class.java)
        startActivity(intent)
//        presenter.updateCurrentWeather()
//        presenter.updateWeatherForecast()
        var a = getSystemService(Context.LOCATION_SERVICE)
    }

    override fun onResume() {
        super.onResume()
        Log.d("AAAAAAAA", PresentersManager.getCity())
        presenter.setCity(PresentersManager.getCity())
        presenter.updateWeatherForecast()
        presenter.updateCurrentWeather()
    }
    override fun showWeather(weatherList : ForecastItem) {
        val recyclerView = findViewById<RecyclerView>(R.id.time_weather_recycle_view)
        val horizontalLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = horizontalLayoutManager
        val adapter = TimeWeatherRecyclerAdapter(this,weatherList)
        recyclerView.adapter = adapter
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }

    override fun showCurrentWeather(weatherItem: WeatherItem){
        currentWeatherImage = findViewById(R.id.current_weather_image)
        currentWeatherImage.setImageResource(weatherStateImageMap[weatherItem.weather[0].main]!!)
        var temperature = findViewById<TextView>(R.id.main_temperature_id)
        temperature.setText((weatherItem.main.temp - 273).toBigDecimal().toString())

    }

    override fun setCity(city: String) {
        cityName = findViewById(R.id.textView)
        cityName.setText(city)
    }

    val weatherStateImageMap = mapOf(
        Pair("Clear", R.drawable.property_1_sun),
        Pair("Clouds", R.drawable.property_1_mostly_cloudy),
        Pair("Rain", R.drawable.property_1_heavy_rain),
        Pair("Drizzle", R.drawable.property_1_sun_and_rain),
        Pair("Smoke", R.drawable.property_1_mostly_cloudy),
        Pair("Haze", R.drawable.property_1_mostly_cloudy),
        Pair("Dust", R.drawable.property_1_mostly_cloudy),
        Pair("Fog", R.drawable.property_1_mostly_cloudy),
        Pair("Thunderstorm", R.drawable.property_1_thunderstorm),
        Pair("Snow", R.drawable.property_1_snow),
        Pair("Mist", R.drawable.property_1_mostly_cloudy))



}


