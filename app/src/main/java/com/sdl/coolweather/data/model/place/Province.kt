package com.sdl.coolweather.data.model.place

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * create by songdongliang on 2019/8/5
 */
@Entity(tableName = "province")
data class Province(@ColumnInfo(name = "name") val name: String,
                    @ColumnInfo(name = "id") @SerializedName("id") val provinceCode: Int,
                    @ColumnInfo(name = "pid") @PrimaryKey var pid: Int)