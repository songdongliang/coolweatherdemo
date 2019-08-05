package com.sdl.coolweather.data.model.place

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * create by songdongliang on 2019/8/5
 */
@Entity(tableName = "province")
data class Province(@ColumnInfo(name = "name") val provinceName: String,
                    @ColumnInfo(name = "id") val provinceCode: Int,
                    @ColumnInfo(name = "pid") @PrimaryKey var pid: Int)