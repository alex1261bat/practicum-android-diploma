package ru.practicum.android.diploma.util.adapter.filter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.practicum.android.diploma.databinding.CountryBinding
import ru.practicum.android.diploma.domain.models.filters.Area

class FilterAdapter(private val clickListener: CountryClickListener) : RecyclerView.Adapter<FilterViewHolder>() {
    var countriesList = ArrayList<Area>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val layoutInspector = LayoutInflater.from(parent.context)
        return FilterViewHolder(
            CountryBinding.inflate(
                layoutInspector,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.bind(countriesList[position])
        holder.itemView.setOnClickListener { clickListener.onCountryClick(countriesList[position]) }
    }

    override fun getItemCount(): Int {
        return countriesList.size
    }

    fun interface CountryClickListener {
        fun onCountryClick(country: Area)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(newList: List<Area>) {
        countriesList = newList as ArrayList<Area>
        notifyDataSetChanged()
    }

    fun getItemByPosition(position: Int) =
        countriesList[position]

}