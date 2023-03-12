package com.hakancevik.countriesproject.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hakancevik.countriesproject.model.Country

class CountryViewModel(application: Application): BaseViewModel(application) {

    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(){
        val exampleCountry = Country("view", "model", "test", "none", "none", "none")
        countryLiveData.value = exampleCountry

    }


}