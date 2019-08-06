package com.sdl.coolweather.ui.area

import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sdl.coolweather.data.PlaceRepository
import com.sdl.coolweather.data.model.place.City
import com.sdl.coolweather.data.model.place.Country
import com.sdl.coolweather.data.model.place.Province
import kotlinx.coroutines.launch

/**
 * create by songdongliang on 2019/8/5
 */
class ChooseAreaViewModel(private val repository: PlaceRepository): ViewModel() {

    var currentLevel = MutableLiveData<Int>()

    var dataChanged = MutableLiveData<Int>()

    var isLoading = MutableLiveData<Boolean>()

    var areaSelected = MutableLiveData<Boolean>()

    var selectedProvince: Province? = null

    var selectedCity: City? = null

    var selectedCountry: Country? = null

    lateinit var provinces: List<Province>

    lateinit var cities: List<City>

    lateinit var counties: List<Country>

    val dataList = ArrayList<String>()

    fun getProvinces() {
        currentLevel.value = ChooseAreaFragment.LEVEL_PROVINCE
        launch {
            provinces = repository.getProvinceList()
            dataList.addAll(provinces.map { it.name })
        }
    }

    private fun getCities() = selectedProvince?.let {
        currentLevel.value = ChooseAreaFragment.LEVEL_CITY
        launch {
            cities = repository.getCityList(it.provinceCode)
            dataList.addAll(cities.map { it.cityName })
        }
    }

    private fun getCounties() = selectedCity?.let {
        currentLevel.value = ChooseAreaFragment.LEVEL_COUNTY
        launch {
            counties = repository.getCountryList(it.provinceId, it.cityCode)
            dataList.addAll(counties.map { it.countryName })
        }
    }

    fun onListViewItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        when {
            currentLevel.value == ChooseAreaFragment.LEVEL_PROVINCE -> {
                selectedProvince = provinces[position]
                getCities()
            }
            currentLevel.value == ChooseAreaFragment.LEVEL_CITY -> {
                selectedCity = cities[position]
                getCounties()
            }
            currentLevel.value == ChooseAreaFragment.LEVEL_COUNTY -> {
                selectedCountry = counties[position]
                areaSelected.value = true
            }
        }
    }

    fun onBack() {
        if (currentLevel.value == ChooseAreaFragment.LEVEL_COUNTY) {
            getCities()
        } else if (currentLevel.value == ChooseAreaFragment.LEVEL_CITY) {
            getProvinces()
        }
    }

    private fun launch(block: suspend () -> Unit) = viewModelScope.launch {
        try {
            isLoading.value = true
            dataList.clear()
            block()
            dataChanged.value = dataChanged.value?.plus(1)
            isLoading.value = false
        } catch (t: Throwable) {
            t.printStackTrace()
            Log.e("choose area", t.message.toString())
            dataChanged.value = dataChanged.value?.plus(1)
            isLoading.value = false
        }
    }
}