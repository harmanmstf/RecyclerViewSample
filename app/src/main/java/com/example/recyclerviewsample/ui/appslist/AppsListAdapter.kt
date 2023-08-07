package com.example.recyclerviewsample.ui.appslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewsample.databinding.ListItemBinding
import com.example.recyclerviewsample.model.Apps
import androidx.navigation.findNavController

class AppsListAdapter : ListAdapter<Apps, AppsListAdapter.MemberViewHolder>(MemberDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MemberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        val member = getItem(position)
        holder.bind(member)
    }

    inner class MemberViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Apps) {
            binding.ivIconList.setImageResource(item.icon)
            binding.tvNameList.text = item.name

            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val app = getItem(position)
                    val action =
                        AppsListFragmentDirections.actionAppsListFragmentToAppDetailFragment(app)
                    binding.root.findNavController().navigate(action)
                }
            }
        }
    }
}

class MemberDiffCallback : DiffUtil.ItemCallback<Apps>() {
    override fun areItemsTheSame(oldItem: Apps, newItem: Apps): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Apps, newItem: Apps): Boolean {
        return oldItem == newItem
    }
}