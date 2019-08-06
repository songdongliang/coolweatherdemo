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
        list!!
    }

    suspend fun getCityList(provinceId: Int) = withContext(Dispatchers.IO) {
        var list = placeDao.getCityList(provinceId).value
        if (list.isNullOrEmpty()) {
            list = network.fetchCityList(provinceId)
            list.forEach { it.provinceId = provinceId }
            placeDao.insertCityList(list)
        }
        list!!
    }

    suspend fun getCountryList(provinceId: Int, cityId: Int) = withContext(Dispatchers.IO) {
        var list = placeDao.getCountryList(cityId).value
        if (list.isNullOrEmpty()) {
            list = network.fetchCountryList(provinceId, cityId)
            list.forEach { it.cityId = cityId }
            placeDao.insertCountryList(list)
        }
        list!!
    }

    companion object {

        private var instance: PlaceRepository? = null

        fun getInstance(placeDao: PlaceDao, network: CoolWeatherNetwork) =
            instance ?: synchronized(this) {
                instance ?: PlaceRepository(placeDao, network)
            }
    }
}