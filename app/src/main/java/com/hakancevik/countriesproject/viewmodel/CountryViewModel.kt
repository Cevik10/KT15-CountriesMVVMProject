package com.hakancevik.countriesproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hakancevik.countriesproject.model.Country

class CountryViewModel: ViewModel() {

    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(){
        val exampleCountry = Country("view", "model", "test", "none", "none", "none")
        countryLiveData.value = exampleCountry

    }


}