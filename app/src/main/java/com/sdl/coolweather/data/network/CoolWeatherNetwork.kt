package com.sdl.coolweather.data.network

import com.sdl.coolweather.data.network.api.PlaceService

/**
 * create by songdongliang on 2019/8/5
 */
class CoolWeatherNetwork {

    private val placeService = ServiceCreator.create(PlaceService::class.java)

    suspend fun fetchProvinceList() = placeService.getProvinces()

    suspend fun fetchCityList(provinceId: Int) = placeService.getCities(provinceId)

    suspend fun fetchCountryList(provinceId: Int, cityId: Int) = placeService.getCounties(provinceId, cityId)

    companion object {

        @Volatile
        private var instance: CoolWeatherNetwork? = null

        fun getInstance(): CoolWeatherNetwork =
            instance ?: synchronized(this) {
                instance ?: CoolWeatherNetwork().also { instance = it }
            }

    }
}