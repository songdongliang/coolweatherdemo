package com.sdl.coolweather.data.network.api

import com.sdl.coolweather.data.model.place.City
import com.sdl.coolweather.data.model.place.Country
import com.sdl.coolweather.data.model.place.Province
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * create by songdongliang on 2019/8/5
 */
interface PlaceService {

    @GET("api/china")
    suspend fun getProvinces(): MutableList<Province>

    @GET("api/china/{provinceId}")
    suspend fun getCities(@Path("provinceId") provinceId: Int): MutableList<City>

    @GET("api/china/{provinceId}/{cityId}")
    suspend fun getCounties(@Path("provinceId") provinceId: Int, @Path("cityId") cityId: Int): MutableList<Country>
}