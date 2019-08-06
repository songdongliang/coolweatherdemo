package com.sdl.coolweather.ui.area

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sdl.coolweather.data.PlaceRepository

/**
 * create by songdongliang on 2019/8/6
 */
class ChooseAreaModelFactory(private val repository: PlaceRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ChooseAreaViewModel(repository) as T
    }
}