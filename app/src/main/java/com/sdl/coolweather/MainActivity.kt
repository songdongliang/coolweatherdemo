package com.sdl.coolweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sdl.coolweather.ui.area.ChooseAreaFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container, ChooseAreaFragment()).commit()
    }
}
