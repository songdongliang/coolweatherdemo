package com.sdl.coolweather.data.model.weather

import com.google.gson.annotations.SerializedName

/**
 * create by songdongliang on 2019/8/15
 */
class Forecast {

    var date: String = ""

    @SerializedName("tmp")
    lateinit var temperature: Temperature

    @SerializedName("cond")
    lateinit var more: More

    inner class Temperature {
        var max = ""
        var min = ""
    }

    inner class More {
        @SerializedName("txt_d")
        var info = ""
    }
}