package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemDesignBinding


class ItemAdapter() : ListAdapter<Item, ItemAdapter.JobViewHolder>(connectionItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDesignBinding.inflate(inflater, parent, false)
        return JobViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class JobViewHolder(private val binding: ItemDesignBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.jobTitle.text = item.title

        }
    }

    companion object {
        private val connectionItemCallback = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }
        }
    }
}

enum class JobListType {
    NAME_VIEW, POSITION_VIEW
}

data class JobListDto(
    val viewType: JobListType,
    val name : String

)
