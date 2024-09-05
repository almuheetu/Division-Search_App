package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentThanaListBinding


class ThanaFragment : Fragment(), ThanaAdapter.OnItemClickListener {
    private lateinit var binding: FragmentThanaListBinding
    private lateinit var thanaAdapter: ThanaAdapter
    private val args: ThanaFragmentArgs by navArgs()


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
        val thanaLists = ArrayList<Thana>()
        for (item in thanaList) {
            if (item.districtName == district.districtName) {
                thanaLists.add(item)
            }
        }
        val recyclerView: RecyclerView = binding.thanaRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        thanaAdapter = ThanaAdapter(thanaLists, this)
        recyclerView.adapter = thanaAdapter
    }

    override fun onItemClick(thana: Thana) {
        val action = ThanaFragmentDirections.actionThanaFragmentToPostFragment(thana)
        view?.findNavController()?.navigate(action)

    }


}