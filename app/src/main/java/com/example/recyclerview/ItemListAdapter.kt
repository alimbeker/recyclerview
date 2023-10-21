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


class ItemListAdapter :
    ListAdapter<JobListDto, BaseContinentViewHolder<*>>(ContinentDiffUtils()) {

    class ContinentDiffUtils : DiffUtil.ItemCallback<JobListDto>() {
        override fun areItemsTheSame(oldItem: JobListDto, newItem: JobListDto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: JobListDto, newItem: JobListDto): Boolean {
            return oldItem == newItem
        }
    }

    class JobViewHolder(override val binding: ItemDesignBinding) :
        BaseContinentViewHolder<ItemDesignBinding>(binding) {
        override fun bindView(item: JobListDto) {
            with(binding) {


                jobTitle.text = item.name
            }
        }
    }

    class HeaderViewHolder(override val binding: HeaderDesignBinding) :
        BaseContinentViewHolder<HeaderDesignBinding>(binding) {
        override fun bindView(item: JobListDto) {
            with(binding) {


                headerName.text = item.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseContinentViewHolder<*> {
        return if (viewType == JobListType.HEADER_VIEW.ordinal) {
            HeaderViewHolder(
                HeaderDesignBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        } else JobViewHolder(
            ItemDesignBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
       )
    }

    override fun onBindViewHolder(holder: BaseContinentViewHolder<*>, position: Int) {
        holder.bindView(getItem(position))
    }
}

abstract class BaseViewHolder<VB : ViewBinding, T>(protected open val binding: VB) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bindView(item: T)
}



abstract class BaseContinentViewHolder<VB : ViewBinding>(override val binding: VB) :
    BaseViewHolder<VB, JobListDto>(binding)

enum class JobListType {
   HEADER_VIEW, JOB_VIEW
}

data class JobListDto(

    val id: Int,
    val viewType: JobListType,
   val name: String
)