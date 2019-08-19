package com.sdl.coolweather.data.model.weather

/**
 * create by songdongliang on 2019/8/15
 */
class AQI {

    lateinit var city: AQICity

    inner class AQICity {
        var aqi = ""
        var pm25 = ""
    }
}