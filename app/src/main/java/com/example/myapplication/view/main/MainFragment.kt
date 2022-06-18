package com.example.myapplication.view.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentMainBinding
import com.example.myapplication.viewmodel.MainViewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private lateinit var _binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        FragmentMainBinding.inflate(inflater, container, false)
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        return _binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val shops = mutableListOf(ShopInfo("ALDI", "Tulpenweg 1, 15834, Rangsdorf", 4,"Distance - 3 km"),
            ShopInfo("LIDL", "Tulpenweg 2, 15834, Rangsdorf", 4, "Distance 2 km"),
            ShopInfo("EDEKA", "Tulpenweg 3, 15834, Rangsdorf", 5, "Distance 5 km"),
            ShopInfo("NETTO", "Tulpenweg 4, 15834, Rangsdorf", 3, "Distance 1 km"),
            ShopInfo("ALDI", "Tulpenweg 7, 15834, Rangsdorf", 4, "Distance 2 km"),
            ShopInfo("LIDL", "Tulpenweg 8, 15834, Rangsdorf", 4, "Distance 3 km"),
            ShopInfo("EDEKA", "Tulpenweg 9, 15834, Rangsdorf", 3,"Distance 7 km"),
            ShopInfo("NETTO", "Tulpenweg 10, 15834, Rangsdorf", 3, "Distance 5 km"))

        _binding.list.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
        _binding.list.adapter = ShopRecyclerViewAdapter(requireContext(), shops)
    }
}