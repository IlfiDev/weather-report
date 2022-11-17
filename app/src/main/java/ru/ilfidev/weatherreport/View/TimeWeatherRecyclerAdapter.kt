package ru.ilfidev.weatherreport.View

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.ilfidev.weatherreport.Model.ForecastItem
import ru.ilfidev.weatherreport.Model.WeatherItem
import ru.ilfidev.weatherreport.R
import java.text.DateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

class TimeWeatherRecyclerAdapter(context: Context, items: ForecastItem) : RecyclerView.Adapter<TimeWeatherRecyclerAdapter.ViewHolder>() {
    val mInflater = LayoutInflater.from(context)
    val weathearItems = items.list.slice(0..7)
    val weatherStateImageMap = mapOf(
        Pair("clear sky", R.drawable.condition_sunny),
        Pair("few clouds", R.drawable.condition_cloudy_at_day),
        Pair("scattered clouds", R.drawable.condition_cloudy_at_day),
        Pair("broken clouds", R.drawable.condition_cloudy),
        Pair("shower rain", R.drawable.condition_rain),
        Pair("rain", R.drawable.condition_rain_opportunity),
        Pair("thunderstorm", R.drawable.condition_thunderstorm),
        Pair("snow", R.drawable.condition_snow),
        Pair("mist", R.drawable.condition_cloudy))

    public class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val temp = itemView.findViewById<TextView>(R.id.time_weather_temperature_id)
        val time = itemView.findViewById<TextView>(R.id.time_weather_time_id)
        val image = itemView.findViewById<ImageView>(R.id.time_weather_image_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val view = mInflater.inflate(R.layout.time_weather_layout, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val temperature = weathearItems[position].main.temp - 273
        val time = weathearItems[position].dt_txt
        var resultTime = ""
        val formattedTimeInt = time.split(" ")[1].split(":")[0].toInt()
        if( formattedTimeInt - 12 <= 0) {
            resultTime = formattedTimeInt.toString() + " am"
        }else{
            resultTime = (formattedTimeInt - 12).toString() + " pm"
        }
        Log.w("Time", resultTime)
        holder.image.setImageResource(weatherStateImageMap[weathearItems[position].weather[0].description]!!)
        holder.temp.setText(temperature.roundToInt().toBigDecimal().toPlainString() + "°")
        holder.time.setText(resultTime)
    }

    override fun getItemCount(): Int {
        return weathearItems.size
    }
}