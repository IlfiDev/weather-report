package ru.ilfidev.weatherreport.View

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.getSystemService
import ru.ilfidev.weatherreport.Model.CityWeatherData
import ru.ilfidev.weatherreport.Model.WeatherItem
import ru.ilfidev.weatherreport.R

class ChooseWeatherAdapter(context: Context, list: List<CityWeatherData>) : BaseAdapter()  {
    var list = list
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
            newView = layoutInflater.inflate(R.layout.city_item_layout, null)
            val cityName = newView?.findViewById<TextView>(R.id.city_name_id)
            val cityTemperature = newView?.findViewById<TextView>(R.id.city_tempereature_id)
            val cityWeatherState = newView?.findViewById<ImageView>(R.id.city_weather_state_id)
            cityName?.setText(list[p0].cityName)
            cityTemperature?.setText(list[p0].cityTemperature.toString())
            cityWeatherState?.setImageResource(weatherStateImageMap[list[p0].cityWeatherState]!!)


        }
        return newView!!
    }
    val weatherStateImageMap = mapOf(
        Pair("Clear", R.drawable.property_1_sun),
        Pair("Clouds", R.drawable.property_1_mostly_cloudy),
        Pair("Rain", R.drawable.property_1_heavy_rain),
        Pair("Thunderstorm", R.drawable.property_1_thunderstorm),
        Pair("Snow", R.drawable.property_1_snow),
        Pair("Mist", R.drawable.property_1_mostly_cloudy))
}