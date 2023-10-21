package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.recyclerview.databinding.HeaderDesignBinding
import com.example.recyclerview.databinding.ItemDesignBinding



class ItemAdapter(
    private val items: List<CountryListDto>
) : RecyclerView.Adapter<BaseCountryViewHolder<*, String>>() {

    val itemClick: ((CountryListDto) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseCountryViewHolder<*, String> {
        return if (viewType == JobListType.HEADER_VIEW.ordinal) {
            HeaderViewHolder(
                HeaderDesignBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        } else JobViewHolder(
            ItemDesignBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), itemClick
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseCountryViewHolder<*, String>, position: Int) {
        holder.bindView(items[position].name)
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType.ordinal
    }

    class JobViewHolder(override val binding: ItemDesignBinding, private val itemClick: ((CountryListDto) -> Unit)?) :
        BaseCountryViewHolder<ItemDesignBinding, String>(binding) {

        override fun bindView(item: String) {
            binding.jobTitle.text = item


        }


    }

    class HeaderViewHolder(override val binding: HeaderDesignBinding) :
        BaseCountryViewHolder<HeaderDesignBinding, String>(binding) {

        override fun bindView(item: String) {
            binding.headerName.text = item


        }
    }
}

abstract class BaseCountryViewHolder<VB: ViewBinding, T>(protected open val binding: VB):
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bindView(item: T)
}

enum class JobListType {
    HEADER_VIEW, JOB_VIEW
}

data class CountryListDto(
    val viewType: JobListType,
    val name: String
)