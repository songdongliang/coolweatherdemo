package com.sdl.coolweather.util

import android.content.Context
import com.sdl.coolweather.data.PlaceRepository
import com.sdl.coolweather.data.db.AppDatabase
import com.sdl.coolweather.data.network.CoolWeatherNetwork
import com.sdl.coolweather.ui.area.ChooseAreaModelFactory

object InjectorUtil {

    private fun getPlaceRepository(context: Context) =
        PlaceRepository.getInstance(AppDatabase.getInstance(context).placeDao(), CoolWeatherNetwork.getInstance())

    fun getChooseAreaModelFactory(context: Context) = ChooseAreaModelFactory(getPlaceRepository(context))
}