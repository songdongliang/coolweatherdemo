package com.sdl.coolweather.data.model.place

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * create by songdongliang on 2019/8/5
 */
@Entity(tableName = "city")
data class City(@ColumnInfo(name = "name") val cityName: String,
                @ColumnInfo(name = "id") val cityCode: Int,
                @ColumnInfo(name = "pid") @PrimaryKey var pid: Int,
                @ColumnInfo(name = "province_id") var provinceId: Int)