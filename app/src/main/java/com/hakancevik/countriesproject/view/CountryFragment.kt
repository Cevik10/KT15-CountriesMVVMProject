package com.hakancevik.countriesproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.hakancevik.countriesproject.R
import com.hakancevik.countriesproject.databinding.FragmentCountryBinding
import com.hakancevik.countriesproject.util.downloadFromUrl
import com.hakancevik.countriesproject.util.placeHolderProgressBar
import com.hakancevik.countriesproject.viewmodel.CountryViewModel
import com.hakancevik.countriesproject.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_country.*


class CountryFragment : Fragment() {


    private lateinit var viewModel: CountryViewModel
    private var countryUuid = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            countryUuid = CountryFragmentArgs.fromBundle(it).countryUuid
        }

        viewModel = ViewModelProviders.of(this).get(CountryViewModel::class.java)
        viewModel.getDataFromRoom(countryUuid)

        observeLiveData()

    }


    private fun observeLiveData() {
        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer { country ->
            country?.let {
                countryNameText.text = country.countryName
                countryRegionText.text = country.countryRegion
                countryCapitalText.text = country.countryCapital
                countryLanguageText.text = country.countryLanguage
                countryCurrencyText.text = country.countryCurrency

                context?.let {
                    countryFlagImageView.downloadFromUrl(country.imageUrl, placeHolderProgressBar(it))
                }

            }

        })

    }

    override fun onDestroyView() {
        super.onDestroyView()

    }


}