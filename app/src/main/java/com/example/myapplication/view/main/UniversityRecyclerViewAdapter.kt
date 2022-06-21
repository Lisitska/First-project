package com.example.myapplication.view.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.UniversityItemBinding

class UniversityRecyclerViewAdapter(private val context: Context,
                              private val university: List<UniversityInfo>): RecyclerView.Adapter<UniversityRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = UniversityItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val university = university[position]
        holder.universityNameView.text = university.name
        holder.universityAddressView.text = university.address
        holder.universityRatingView.text = "Rating " + university.rating.toString()
        holder.universityDistanceView.text = university.distance
    }

    override fun getItemCount(): Int {
        return university.size
    }

    class ViewHolder(binding: UniversityItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val universityNameView = binding.universityName
        val universityAddressView = binding.universityAddress
        val universityRatingView = binding.universityRating
        val universityDistanceView = binding.universityDistance
    }
}