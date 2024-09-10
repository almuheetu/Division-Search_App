package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentPostListBinding
import viewModel.PostViewModel

class PostFragment : Fragment() {
    private lateinit var binding: FragmentPostListBinding
    private lateinit var postAdapter: PostAdapter
    private val args: PostFragmentArgs by navArgs()
    private val viewModel: PostViewModel by viewModels()

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
        val recyclerView: RecyclerView = binding.postRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.posts.observe(viewLifecycleOwner) {
            val posts = postList.filter { it.thanaName == thana.thanaName } as ArrayList<Post>
            postAdapter = PostAdapter(posts)
            recyclerView.adapter = postAdapter
        }
//        val posts = viewModel.getPosts(thana.thanaName)
//        postAdapter = PostAdapter(posts)
//        recyclerView.adapter = postAdapter


    }

}