package com.estudo.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class CountryAdapter(
    var countryNameList: ArrayList<String>,
    var detailsList: ArrayList<String>,
    var imageList: ArrayList<Int>,
    var context: Context
): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        p1: Int
    ): CountryViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.card_design, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CountryViewHolder,
        position: Int
    ) {
        holder.textViewCountryName.text = countryNameList.get(position)
        holder.textViewCountryDetails.text = detailsList.get(position)
        holder.imageView.setImageResource(imageList.get(position))
    }

    override fun getItemCount(): Int {
        return countryNameList.size
    }

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewCountryName: TextView = itemView.findViewById(R.id.country_name)
        var textViewCountryDetails: TextView = itemView.findViewById(R.id.country_details)
        var imageView: CircleImageView = itemView.findViewById(R.id.image_view)
    }
}