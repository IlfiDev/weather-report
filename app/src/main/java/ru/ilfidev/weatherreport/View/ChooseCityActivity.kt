package ru.ilfidev.weatherreport.View

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnKeyListener
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import ru.ilfidev.weatherreport.Model.CityWeatherData
import ru.ilfidev.weatherreport.Model.ForecastItem
import ru.ilfidev.weatherreport.Model.WeatherItem
import ru.ilfidev.weatherreport.Presenter.ChooseCityPresenter
import ru.ilfidev.weatherreport.Presenter.DependencyInjectionImpl
import ru.ilfidev.weatherreport.R

class ChooseCityActivity : AppCompatActivity(), MainContract.View {
    private lateinit var editText: EditText
    private lateinit var listView: ListView
    private lateinit var button: Button
    private lateinit var presenter: MainContract.Presenter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_city)
        editText = findViewById(R.id.find_text_id)

        listView = findViewById(R.id.city_listview_id)
        button = findViewById(R.id.search_button)
        setPresenter(ChooseCityPresenter(this, DependencyInjectionImpl()))
        button.setOnClickListener(object: OnClickListener{
            override fun onClick(p0: View?) {
                presenter.setCity(editText.text.toString())
                presenter.updateCurrentWeather()
            }
        })
        getSupportActionBar()?.hide()
    }

    override fun showWeather(weatherList: ForecastItem) {
        TODO("Not yet implemented")
    }

    override fun showCurrentWeather(weatherItem: WeatherItem) {
        finish()
    }

    override fun setCity(city: String) {
        TODO("Not yet implemented")
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }
}