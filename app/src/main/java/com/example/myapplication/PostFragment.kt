package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentPostListBinding

class PostFragment : Fragment() {
    private lateinit var binding: FragmentPostListBinding
    private lateinit var postAdapter: PostAdapter
    private val args: PostFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val thana = args.data
        val postLists = postList.filter { it.thanaName == thana.thanaName } as ArrayList<Post>
        val recyclerView: RecyclerView = binding.postRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        postAdapter = PostAdapter(postLists)
        recyclerView.adapter = postAdapter

    }

}