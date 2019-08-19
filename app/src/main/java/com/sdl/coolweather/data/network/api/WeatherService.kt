package com.sdl.coolweather.data.network.api

import com.sdl.coolweather.data.model.weather.HeWeather
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * create by songdongliang on 2019/8/15
 */
interface WeatherService {

    @GET("api/weather")
    suspend fun getWeather(@Query("cityid") weatherId: String): HeWeather

    @GET("api/bing_pic")
    suspend fun getBingPic(): String
}