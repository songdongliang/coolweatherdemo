package com.sdl.coolweather.ui.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sdl.coolweather.data.WeatherRepository

/**
 * create by songdongliang on 2019/8/16
 */
class WeatherModelFactory(private val repository: WeatherRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WeatherViewModel(repository) as T
    }
}