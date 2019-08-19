package com.sdl.coolweather.data.network

import com.sdl.coolweather.data.network.api.PlaceService
import com.sdl.coolweather.data.network.api.WeatherService

/**
 * create by songdongliang on 2019/8/5
 */
class CoolWeatherNetwork {

    private val placeService = ServiceCreator.create(PlaceService::class.java)

    private val weatherService = ServiceCreator.create(WeatherService::class.java)

    suspend fun fetchProvinceList() = placeService.getProvinces()

    suspend fun fetchCityList(provinceId: Int) = placeService.getCities(provinceId)

    suspend fun fetchCountryList(provinceId: Int, cityId: Int) = placeService.getCounties(provinceId, cityId)

    suspend fun fetchWeather(weatherId: String) = weatherService.getWeather(weatherId)

    suspend fun fetchBingPic() = weatherService.getBingPic()

    companion object {

        @Volatile
        private var instance: CoolWeatherNetwork? = null

        fun getInstance(): CoolWeatherNetwork =
            instance ?: synchronized(this) {
                instance ?: CoolWeatherNetwork().also { instance = it }
            }

    }
}