package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.recyclerview.databinding.HeaderDesignBinding
import com.example.recyclerview.databinding.ItemDesignBinding


class ItemListAdapter(private val items: List<JobListDto>) :
    ListAdapter<JobListDto, BaseJobViewHolder<*,String>>(ContinentDiffUtils()) {


    var itemClick: ((String) -> Unit)? = null

    class ContinentDiffUtils : DiffUtil.ItemCallback<JobListDto>() {
        override fun areItemsTheSame(oldItem: JobListDto, newItem: JobListDto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: JobListDto, newItem: JobListDto): Boolean {
            return oldItem == newItem
        }
    }

    class JobViewHolder(override val binding: ItemDesignBinding, val itemClick: ((String) -> Unit)?) :
        BaseJobViewHolder<ItemDesignBinding, String>(binding) {

        override fun bindView(item: String) {
            binding.jobTitle.text = item

            itemView.setOnClickListener {
                itemClick?.invoke(item)
            }

        }


    }

    class HeaderViewHolder(override val binding: HeaderDesignBinding) :
        BaseJobViewHolder<HeaderDesignBinding, String>(binding) {

        override fun bindView(item: String) {
            binding.headerName.text = item


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseJobViewHolder<*, String> {
        return if (viewType == JobListType.HEADER_VIEW.ordinal) {
            HeaderViewHolder(
                HeaderDesignBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        } else JobViewHolder(
            ItemDesignBinding.inflate(
                LayoutInflater.from(parent.context), parent, false,
            ),  itemClick
        )
    }
    override fun getItemViewType(position: Int): Int {
                return items[position].viewType.ordinal
    }
    override fun onBindViewHolder(holder: BaseJobViewHolder<*, String>, position: Int) {
        holder.bindView(items[position].name)
    }
}

abstract class BaseJobViewHolder<VB: ViewBinding, T>(protected open val binding: VB):
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bindView(item: T)
}




enum class JobListType {
   HEADER_VIEW, JOB_VIEW
}

data class JobListDto(

    val id: Int,
    val viewType: JobListType,
   val name: String
)