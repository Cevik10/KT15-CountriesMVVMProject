package com.hakancevik.countriesproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.hakancevik.countriesproject.R
import com.hakancevik.countriesproject.model.Country
import com.hakancevik.countriesproject.util.downloadFromUrl
import com.hakancevik.countriesproject.util.placeHolderProgressBar
import com.hakancevik.countriesproject.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.recycler_row.view.*

class CountryAdapter(private val countryList: ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_row, parent, false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        holder.view.recyclerViewCountryNameText.text = countryList[position].countryName
        holder.view.recyclerViewRegionText.text = countryList[position].countryRegion
        holder.view.recyclerViewImageView.downloadFromUrl(countryList[position].imageUrl, placeHolderProgressBar(holder.view.context))

        holder.view.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment(countryList[position].uuid)
            Navigation.findNavController(it).navigate(action)
        }

    }


    fun updateCountryList(newCountryList: List<Country>) {
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }


}