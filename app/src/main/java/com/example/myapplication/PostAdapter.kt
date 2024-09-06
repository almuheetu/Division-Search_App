package com.example.myapplication

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup

import com.example.myapplication.databinding.AdapterPostBinding

class PostAdapter(
    private val postList: ArrayList<Post>,

    ) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    class ViewHolder(val binding: AdapterPostBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterPostBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false

        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val post = postList[position]
        viewHolder.binding.tvPostName.text = post.postName
    }

    override fun getItemCount(): Int {
        return postList.size
    }

}