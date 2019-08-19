package com.sdl.coolweather.data.model.weather

import com.google.gson.annotations.SerializedName

/**
 * create by songdongliang on 2019/8/15
 */
class Suggestion {

    @SerializedName("comf")
    lateinit var comfort: Comfort

    @SerializedName("cw")
    lateinit var carWash: CarWash

    lateinit var sport: Sport

    inner class Comfort {
        @SerializedName("txt")
        var info = ""
    }

    inner class CarWash {
        @SerializedName("txt")
        var info = ""
    }

    inner class Sport {
        @SerializedName("txt")
        var info = ""
    }
}