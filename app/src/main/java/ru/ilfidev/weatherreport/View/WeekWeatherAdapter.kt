package ru.ilfidev.weatherreport.View

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import ru.ilfidev.weatherreport.Model.WeatherItem
import ru.ilfidev.weatherreport.R
import java.text.SimpleDateFormat
import java.util.*

class WeekWeatherAdapter(context: Context, list: List<WeatherItem>) : BaseAdapter() {
    var list = list.slice(0..39 step 8)
    var context = context
    var layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var newView = p1
        if(newView == null){
            newView = layoutInflater.inflate(R.layout.day_weather_layout, null)
        }
        val dayOfTheWeek = newView?.findViewById<TextView>(R.id.day_of_the_week_id)
        val dayTemperature = newView?.findViewById<TextView>(R.id.day_of_the_week_day_temp_id)
        val dayWeatherStatus = newView?.findViewById<ImageView>(R.id.day_of_the_week_weather_status_id)
        val nightTemperature = newView?.findViewById<TextView>(R.id.day_of_the_week_night_temp_id)

        dayOfTheWeek?.setText(list[p0].dt_txt.split(" ")[0])
        dayTemperature?.setText((list[p0].main.temp_max - 273).toBigDecimal().toPlainString())
        nightTemperature?.setText((list[p0].main.temp_min - 273).toBigDecimal().toPlainString())
        dayWeatherStatus?.setImageResource(weatherStateImageMap[list[p0].weather[0].main]!!)
        return newView!!
    }
    val weatherStateImageMap = mapOf(
        Pair("Clear", R.drawable.condition_sunny),
        Pair("Clouds", R.drawable.condition_cloudy),
        Pair("Rain", R.drawable.condition_rain),
        Pair("Drizzle", R.drawable.property_1_sun_and_rain),
        Pair("Smoke", R.drawable.property_1_mostly_cloudy),
        Pair("Haze", R.drawable.property_1_mostly_cloudy),
        Pair("Dust", R.drawable.property_1_mostly_cloudy),
        Pair("Fog", R.drawable.property_1_mostly_cloudy),
        Pair("Thunderstorm", R.drawable.condition_thunderstorm),
        Pair("Snow", R.drawable.condition_snow),
        Pair("Mist", R.drawable.condition_cloudy))}