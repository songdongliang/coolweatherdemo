package com.sdl.coolweather.data.model.weather

import com.google.gson.annotations.SerializedName

/**
 * create by songdongliang on 2019/8/15
 */
class HeWeather {

    @SerializedName("HeWeather")
    var weather: List<Weather>? = null
}