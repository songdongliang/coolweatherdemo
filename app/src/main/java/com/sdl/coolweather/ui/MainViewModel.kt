package com.sdl.coolweather.ui

import androidx.lifecycle.ViewModel
import com.sdl.coolweather.data.WeatherRepository

/**
 * create by songdongliang on 2019/8/19
 */
class MainViewModel(private val repository: WeatherRepository): ViewModel() {

    fun isWeatherCached() = repository.isWeatherCached()
}