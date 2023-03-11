package com.hakancevik.countriesproject.service

import com.hakancevik.countriesproject.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryAPI {

    //https://raw.githubusercontent.com/Cevik10/KT14-CountriesMVVMProject/master/countriesdataset.json

    @GET("Cevik10/KT14-CountriesMVVMProject/master/countriesdataset.json")
    fun getCountries(): Single<List<Country>>


}