package com.example.myapplication.view.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ShopItemBinding

class ShopRecyclerViewAdapter(private val context: Context,
                              private val shops: List<ShopInfo>): RecyclerView.Adapter<ShopRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ShopItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shop = shops[position]
        holder.shopNameView.text = shop.name
        holder.shopAddressView.text = shop.address
        holder.shopRatingView.text = "Rating " + shop.rating.toString()
        holder.shopDistanceView.text = shop.distance
    }

    override fun getItemCount(): Int {
        return shops.size
    }

    class ViewHolder(binding: ShopItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val shopNameView = binding.shopName
        val shopAddressView = binding.shopAddress
        val shopRatingView = binding.shopRating
        val shopDistanceView = binding.shopDistance
    }
}