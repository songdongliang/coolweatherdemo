package com.sdl.coolweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * create by songdongliang on 2019/8/6
 */
class CoolWeatherApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }
}