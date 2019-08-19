package com.sdl.coolweather.data.model.weather

import com.google.gson.annotations.SerializedName

/**
 * create by songdongliang on 2019/8/15
 */
class Now {

    @SerializedName("tmp")
    var temperature = ""
    @SerializedName("cond")
    lateinit var more: More

    fun degree() = "$temperature℃"

    inner class More {
        @SerializedName("txt")
        var info = ""
    }
}