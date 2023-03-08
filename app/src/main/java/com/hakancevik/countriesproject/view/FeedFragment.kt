package com.hakancevik.countriesproject.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.hakancevik.countriesproject.R
import com.hakancevik.countriesproject.adapter.CountryAdapter
import com.hakancevik.countriesproject.databinding.FragmentFeedBinding
import com.hakancevik.countriesproject.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_feed.*


class FeedFragment : Fragment() {

    private lateinit var viewModel: FeedViewModel
    private val countryAdapter = CountryAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProviders.of(this).get(FeedViewModel::class.java)
        viewModel.refreshData()

        countryListRecyclerView.layoutManager = LinearLayoutManager(context)
        countryListRecyclerView.adapter = countryAdapter

        observerLiveData()


    }

    private fun observerLiveData() {
        viewModel.countries.observe(viewLifecycleOwner, Observer {
            it?.let {
                countryListRecyclerView.visibility = View.VISIBLE
                countryAdapter.updateCountryList(it)

            }
        })

        viewModel.countryError.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it) {
                    countryErrorText.visibility = View.VISIBLE
                } else {
                    countryErrorText.visibility = View.GONE
                }

            }

        })

        viewModel.countryLoading.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it) {
                    countryProgressBar.visibility = View.VISIBLE
                    countryListRecyclerView.visibility = View.GONE
                    countryErrorText.visibility = View.GONE
                } else {
                    countryProgressBar.visibility = View.GONE
                }


            }

        })


    }


    override fun onDestroyView() {
        super.onDestroyView()


    }


}