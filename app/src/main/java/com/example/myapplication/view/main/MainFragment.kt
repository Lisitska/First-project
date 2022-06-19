package com.example.myapplication.view.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

        viewModel.shopList.observe(viewLifecycleOwner) {
            when (it) {
                null -> {
                    Toast.makeText(activity,"Error", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    _binding.list.layoutManager =
                        androidx.recyclerview.widget.LinearLayoutManager(context)
                    _binding.list.adapter = ShopRecyclerViewAdapter(requireContext(), it)
                }
            }
        }
    }
}