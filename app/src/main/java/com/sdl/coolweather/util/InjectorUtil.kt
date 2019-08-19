package com.sdl.coolweather.util

import android.content.Context
import com.sdl.coolweather.data.PlaceRepository
import com.sdl.coolweather.data.WeatherRepository
import com.sdl.coolweather.data.db.AppDatabase
import com.sdl.coolweather.data.db.WeatherDao
import com.sdl.coolweather.data.network.CoolWeatherNetwork
import com.sdl.coolweather.ui.MainModelFactory
import com.sdl.coolweather.ui.area.ChooseAreaModelFactory
import com.sdl.coolweather.ui.weather.WeatherModelFactory

object InjectorUtil {

    private fun getPlaceRepository(context: Context) =
        PlaceRepository.getInstance(AppDatabase.getInstance(context).placeDao(), CoolWeatherNetwork.getInstance())

    private fun getWeatherRepository() =
        WeatherRepository.getInstance(WeatherDao(), CoolWeatherNetwork.getInstance())

    fun getChooseAreaModelFactory(context: Context) = ChooseAreaModelFactory(getPlaceRepository(context))

    fun getWeatherModelFactory() = WeatherModelFactory(getWeatherRepository())

    fun getMainModelFactory() = MainModelFactory(getWeatherRepository())
}