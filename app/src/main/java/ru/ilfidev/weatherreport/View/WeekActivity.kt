package ru.ilfidev.weatherreport.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import ru.ilfidev.weatherreport.Model.ForecastItem
import ru.ilfidev.weatherreport.Model.WeatherItem
import ru.ilfidev.weatherreport.Presenter.DependencyInjectionImpl
import ru.ilfidev.weatherreport.Presenter.PresentersManager
import ru.ilfidev.weatherreport.Presenter.WeekPresenter
import ru.ilfidev.weatherreport.R

class WeekActivity : AppCompatActivity(), MainContract.View {
    private lateinit var presenter: MainContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week)
        getSupportActionBar()?.hide()
        setPresenter(WeekPresenter(this, DependencyInjectionImpl()))
        presenter.setCity(PresentersManager.getCity())
        presenter.updateWeatherForecast()
    }

    override fun showWeather(weatherList: ForecastItem) {
        var listView = findViewById<ListView>(R.id.week_listview)
        listView.adapter = WeekWeatherAdapter(this, weatherList.list)
    }

    override fun showCurrentWeather(weatherItem: WeatherItem) {
        TODO("Not yet implemented")
    }

    override fun setCity(city: String) {
        TODO("Not yet implemented")
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }
}