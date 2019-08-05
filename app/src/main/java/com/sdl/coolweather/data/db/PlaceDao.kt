package com.sdl.coolweather.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sdl.coolweather.data.model.place.City
import com.sdl.coolweather.data.model.place.Country
import com.sdl.coolweather.data.model.place.Province

/**
 * create by songdongliang on 2019/8/5
 */
@Dao
interface PlaceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCityList(cities: List<City>)

    @Query("SELECT * FROM city WHERE province_id = :provinceId")
    fun getCityList(provinceId: Int): LiveData<List<City>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCountryList(countries: List<Country>)

    @Query("SELECT * FROM country WHERE city_id = :cityId")
    fun getCountryList(cityId: Int): LiveData<List<Country>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProvinceList(provinces: List<Province>)

    @Query("SELECT * FROM province")
    fun getProviceList(): LiveData<List<Province>>
}