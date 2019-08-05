package com.sdl.coolweather.data

import com.sdl.coolweather.data.db.PlaceDao
import com.sdl.coolweather.data.network.CoolWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * create by songdongliang on 2019/8/5
 */
class PlaceRepository private constructor(private val placeDao: PlaceDao, private val network: CoolWeatherNetwork){

    suspend fun getProvinceList() = withContext(Dispatchers.IO) {
        var list = placeDao.getProviceList().value
        if (list.isNullOrEmpty()) {
            list = network.fetchProvinceList()
            placeDao.insertProvinceList(list)
        }
        list
    }
}