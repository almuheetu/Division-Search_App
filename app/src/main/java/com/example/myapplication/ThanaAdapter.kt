package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.databinding.AdapterThanaBinding

class ThanaAdapter(
    private val thanaList: ArrayList<Thana>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<ThanaAdapter.ViewHolder>() {
    class ViewHolder(val binding: AdapterThanaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterThanaBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val thana = thanaList[position]
        viewHolder.binding.tvThanaName.text = thana.thanaName
        viewHolder.itemView.setOnClickListener {
            listener.onItemClick(thana)
        }
    }

    override fun getItemCount(): Int {
        return thanaList.size
    }

    interface OnItemClickListener {
        fun onItemClick(thana: Thana)
    }

}