package com.sdl.coolweather.ui.weather

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import com.sdl.coolweather.R
import com.sdl.coolweather.databinding.ActivityWeatherBinding
import com.sdl.coolweather.util.InjectorUtil

class WeatherActivity : AppCompatActivity() {

    val viewModel by lazy {
        ViewModelProviders.of(this, InjectorUtil.getWeatherModelFactory(this)).get(WeatherViewModel::class.java)
    }

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityWeatherBinding>(this, R.layout.activity_weather)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= 21) {
            val decorView = window.decorView
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.statusBarColor = Color.TRANSPARENT
        }
        binding.viewModel = viewModel
        binding.resId = R.color.colorPrimary
        binding.lifecycleOwner = this as LifecycleOwner
        viewModel.weatherId = if (viewModel.isWeatherCached()) {
            viewModel.getCachedWeather().basic.weatherId
        } else {
            intent.getStringExtra("weather_id") ?: ""
        }
        viewModel.getWeather()
    }
}
