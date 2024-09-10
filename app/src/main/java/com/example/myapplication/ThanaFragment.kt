package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentThanaListBinding
import viewModel.ThanaViewModel

class ThanaFragment : Fragment(), ThanaAdapter.OnItemClickListener {
    private lateinit var binding: FragmentThanaListBinding
    private lateinit var thanaAdapter: ThanaAdapter
    private val args: ThanaFragmentArgs by navArgs()
    private val viewModel: ThanaViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThanaListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val district = args.data
        val recyclerView: RecyclerView = binding.thanaRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.getThana()
        viewModel.thanas.observe(viewLifecycleOwner) {
            val thanaLists =
                thanaList.filter { it.districtName == district.districtName } as ArrayList<Thana>
            thanaAdapter = ThanaAdapter(thanaLists, this)
            recyclerView.adapter = thanaAdapter
            binding.thanaLoadingId.root.visibility = View.GONE
            binding.thanaRecyclerView.visibility = View.VISIBLE
        }
    }

    override fun onItemClick(thana: Thana) {
        val action = ThanaFragmentDirections.actionThanaFragmentToPostFragment(thana)
        view?.findNavController()?.navigate(action)
    }
}