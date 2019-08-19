package com.sdl.coolweather.data.model.weather

import com.google.gson.annotations.SerializedName

/**
 * create by songdongliang on 2019/8/15
 */
class Weather {

    var status = ""

    lateinit var basic: Basic

    lateinit var aqi: AQI

    lateinit var now: Now

    lateinit var suggestion: Suggestion

    @SerializedName("daily_forecast")
    lateinit var forecastList: List<Forecast>
}