package com.hakancevik.countriesproject.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.hakancevik.countriesproject.model.Country

@Dao
interface CountryDao {

    @Insert
    suspend fun insertAll(vararg countries: Country): List<Long>

    @Query(value = "SELECT * FROM country")
    suspend fun getAllCountries(): List<Country>

    @Query(value = "SELECT * FROM country WHERE uuid = :countryID")
    suspend fun getCountry(countryID: Int): Country

    @Query(value = "DELETE * FROM country")
    suspend fun deleteAllCountries()

}