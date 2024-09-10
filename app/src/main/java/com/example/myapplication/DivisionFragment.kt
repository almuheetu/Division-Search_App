package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentDivisionListBinding
import viewModel.DivisionViewModel


class DivisionFragment : Fragment(), DivisionAdapter.OnItemClickListener {
    private lateinit var binding: FragmentDivisionListBinding
    private lateinit var divisionAdapter: DivisionAdapter
    private val viewModel: DivisionViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDivisionListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = binding.divisionRecyclerView
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        viewModel.getItems()
        viewModel.division.observe(viewLifecycleOwner, Observer { divisions ->
            divisionAdapter = DivisionAdapter(divisions, this)
            recyclerView.adapter = divisionAdapter
            binding.loadingId.root.visibility = View.GONE
            binding.divisionRecyclerView.visibility = View.VISIBLE
        })
    }

    override fun onItemClick(division: Division) {
        val action = DivisionFragmentDirections.actionDivisionFragmentToDistrictFragment(division)
        findNavController().navigate(action)

    }


}