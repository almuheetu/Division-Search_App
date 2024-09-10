package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.databinding.FragmentDistrictListBinding
import viewModel.DistrictViewModel


class DistrictFragment : Fragment(), DistrictAdapter.OnItemClickListener {
    private lateinit var binding: FragmentDistrictListBinding
    private lateinit var districtAdapter: DistrictAdapter
    private val args: DistrictFragmentArgs by navArgs()
    private val viewModel: DistrictViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDistrictListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val division = args.data
        val recyclerView: RecyclerView = binding.districtRecyclerView
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        viewModel.getDistricts()
        viewModel.districts.observe(viewLifecycleOwner) {
            val districts =
                districtList.filter { it.divisionName == division.divisionName } as ArrayList<District>
            districtAdapter = DistrictAdapter(districts, this)
            recyclerView.adapter = districtAdapter
            binding.districtLoadingId.root.visibility = View.GONE
            binding.districtRecyclerView.visibility = View.VISIBLE
        }
    }

    override fun onItemClick(district: District) {
        val action = DistrictFragmentDirections.actionDistrictFragmentToThanaFragment(district)
        findNavController().navigate(action)
    }

}
