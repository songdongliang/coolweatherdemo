package com.sdl.coolweather.data.model.weather

import com.google.gson.annotations.SerializedName

/**
 * create by songdongliang on 2019/8/14
 */
class Basic {

    @SerializedName("city")
    var cityName = ""
    @SerializedName("id")
    var weatherId = ""

    lateinit var update: Update

    inner class Update {
        @SerializedName("loc")
        var updateTime = ""

        fun time() = updateTime.split(" ")[1]
    }
}