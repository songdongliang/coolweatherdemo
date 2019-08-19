package com.sdl.coolweather.data.db

import android.content.Context
import com.google.gson.Gson
import com.sdl.coolweather.CoolWeatherApplication
import com.sdl.coolweather.data.model.weather.Weather

/**
 * create by songdongliang on 2019/8/15
 */
class WeatherDao {

    fun cacheWeatherInfo(weather: Weather?) {
        if (weather == null) return
        CoolWeatherApplication.context.getSharedPreferences("cool", Context.MODE_PRIVATE).edit().apply {
            val weatherInfo = Gson().toJson(weather)
            putString("weather", weatherInfo)
        }.apply()
    }

    fun getCachedWeatherInfo(): Weather? {
        val weatherInfo = CoolWeatherApplication.context
            .getSharedPreferences("cool", Context.MODE_PRIVATE).getString("weather", null)
        if (weatherInfo != null) {
            return Gson().fromJson(weatherInfo, Weather::class.java)
        }
        return null
    }

    fun cacheBingPic(bingPic: String?) {
        bingPic?.let {
            CoolWeatherApplication.context.getSharedPreferences("cool", Context.MODE_PRIVATE).edit().apply {
                putString("bing_pic", bingPic)
            }.apply()
        }
    }

    fun getCachedBingPic(): String? = CoolWeatherApplication.context
        .getSharedPreferences("cool", Context.MODE_PRIVATE).getString("bing_pic", null)
}