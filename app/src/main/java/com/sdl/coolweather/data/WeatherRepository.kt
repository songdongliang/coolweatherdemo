package com.sdl.coolweather.data

import com.sdl.coolweather.data.db.WeatherDao
import com.sdl.coolweather.data.model.weather.Weather
import com.sdl.coolweather.data.network.CoolWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * create by songdongliang on 2019/8/15
 */
class WeatherRepository private constructor(private val weatherDao: WeatherDao, private val network: CoolWeatherNetwork){

    suspend fun getWeather(weatherId: String): Weather {
        val weather = weatherDao.getCachedWeatherInfo()
        return weather ?: requestWeather(weatherId)
    }

    suspend fun refreshWeather(weatherId: String) = requestWeather(weatherId)

    private suspend fun requestWeather(weatherId: String) = withContext(Dispatchers.IO) {
        val heWeather = network.fetchWeather(weatherId)
        val weather = heWeather.weather!![0]
        weatherDao.cacheWeatherInfo(weather)
        weather
    }

    suspend fun getBingPic(): String {
        val url = weatherDao.getCachedBingPic()
        return url ?: requestBingPic()
    }

    suspend fun refreshBingPic() = requestBingPic()

    fun isWeatherCached() = weatherDao.getCachedWeatherInfo() != null

    fun getCachedWeather() = weatherDao.getCachedWeatherInfo()!!

    private suspend fun requestBingPic() = withContext(Dispatchers.IO) {
        val url = network.fetchBingPic()
        weatherDao.cacheBingPic(url)
        url
    }

    companion object {

        private var instance: WeatherRepository? = null

        fun getInstance(weatherDao: WeatherDao, network: CoolWeatherNetwork): WeatherRepository {
            return instance ?: synchronized(this) {
                instance ?: WeatherRepository(weatherDao, network)
            }
        }
    }
}