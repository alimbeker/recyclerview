package com.example.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.recyclerview.databinding.FragmentArchiveBinding
import com.example.recyclerview.databinding.FragmentSplashScreenBinding
import com.example.recyclerview.decoration.HeaderDecoration
import com.example.recyclerview.decoration.OffsetDecoration


class ArchiveFragment : Fragment() {
    private lateinit var binding : FragmentArchiveBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArchiveBinding.inflate(inflater, container, false)
        val recyclerView = binding.recyclerView

        val items = listOf(
            JobListDto(1,JobListType.HEADER_VIEW, "Designer"),
            JobListDto(2,JobListType.JOB_VIEW, "Junior UX Designer"),
            JobListDto(3,JobListType.JOB_VIEW, "Junior Product Designer"),
            JobListDto(4,JobListType.HEADER_VIEW, "Android"),
            JobListDto(5,JobListType.JOB_VIEW, "Junior Android Developer"),
            JobListDto(6,JobListType.JOB_VIEW, "Senior Android Developer"),
            JobListDto(7,JobListType.HEADER_VIEW, "IOS"),
            JobListDto(8,JobListType.JOB_VIEW, "Junior IOS Developer"),
            JobListDto(9,JobListType.JOB_VIEW, "Senior IOS Developer"),
            JobListDto(10,JobListType.HEADER_VIEW, "Backend developer"),
            JobListDto(11,JobListType.JOB_VIEW, "Junior Java Developer"),
            JobListDto(12,JobListType.JOB_VIEW, "Middle .NET Developer"),
            JobListDto(13,JobListType.HEADER_VIEW, "QA Engineer"),
            JobListDto(14,JobListType.JOB_VIEW, "Junior QA Engineer"),
            JobListDto(15,JobListType.JOB_VIEW, "Strong Junior QA Engineer")

        )
        val adapter = ItemListAdapter(items)

        adapter.itemClick = {
           findNavController(this).navigate(R.id.action_archiveFragment_to_listingFragment)
        }


        recyclerView.layoutManager = LinearLayoutManager(this.context)



        LinearSnapHelper().attachToRecyclerView(recyclerView)
        recyclerView.adapter = adapter

        adapter.submitList(items)


        val offsetDecoration = OffsetDecoration(start = 16, top = 16, end = 15, bottom = 16)
        val headerDecoration = HeaderDecoration()
        recyclerView.addItemDecoration(offsetDecoration)
        recyclerView.addItemDecoration(headerDecoration)

        recyclerView.swipeToLike {
            Toast.makeText(this.context, items[it].name, Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }


}
