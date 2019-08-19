package com.sdl.coolweather.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sdl.coolweather.data.WeatherRepository

/**
 * create by songdongliang on 2019/8/19
 */
class MainModelFactory(private val repository: WeatherRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}