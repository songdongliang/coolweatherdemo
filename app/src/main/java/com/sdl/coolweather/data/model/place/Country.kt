package com.sdl.coolweather.data.model.place

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * create by songdongliang on 2019/8/5
 */
@Entity(tableName = "country")
data class Country(@ColumnInfo(name = "name") @SerializedName("name") val countryName: String,
                   @ColumnInfo(name = "weather_id") @SerializedName("weather_id") val weatherId: String,
                   @ColumnInfo(name = "pid") @PrimaryKey var pid: Int,
                   @ColumnInfo(name = "city_id") var cityId: Int)