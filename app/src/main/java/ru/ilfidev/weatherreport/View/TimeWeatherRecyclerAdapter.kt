package ru.ilfidev.weatherreport.View

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.ilfidev.weatherreport.Model.ForecastItem
import ru.ilfidev.weatherreport.Model.WeatherItem
import ru.ilfidev.weatherreport.R
import kotlin.math.roundToInt

class TimeWeatherRecyclerAdapter(context: Context, items: ForecastItem) : RecyclerView.Adapter<TimeWeatherRecyclerAdapter.ViewHolder>() {
    val mInflater = LayoutInflater.from(context)
    val weathearItems = items


    public class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val myView = itemView.findViewById<TextView>(R.id.time_weather_temperature_id)
        val temp = myView.findViewById<TextView>(R.id.time_weather_temperature_id)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val view = mInflater.inflate(R.layout.time_weather_layout, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val temperature = weathearItems.list.get(position).main.temp - 273
        holder.temp.setText(temperature.roundToInt().toBigDecimal().toPlainString())
    }

    override fun getItemCount(): Int {
        return weathearItems.list.size
    }
}