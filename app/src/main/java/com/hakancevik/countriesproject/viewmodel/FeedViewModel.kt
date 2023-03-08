package com.hakancevik.countriesproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hakancevik.countriesproject.model.Country

class FeedViewModel : ViewModel() {

    val countries = MutableLiveData<List<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()


    fun refreshData() {

        val exampleCountry = Country("turkey", "europe", "Ankara", "tl", "turkish", "none")
        val example1Country = Country("malesia", "europe", "Ankara", "tl", "turkish", "none")
        val example2Country = Country("france", "europe", "Ankara", "tl", "turkish", "none")
        val example3Country = Country("ukraine", "europe", "Ankara", "tl", "turkish", "none")
        val example4Country = Country("russia", "europe", "Ankara", "tl", "turkish", "none")
        val example5Country = Country("china", "europe", "Ankara", "tl", "turkish", "none")
        val countryList = arrayListOf<Country>(exampleCountry,example1Country,example2Country,example3Country,example4Country,example5Country)

        countries.value = countryList
        countryError.value = false
        countryLoading.value = false

    }


}