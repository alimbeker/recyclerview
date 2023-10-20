package com.example.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.FragmentArchiveBinding
import com.example.recyclerview.databinding.FragmentSplashScreenBinding


class ArchiveFragment : Fragment() {
    private lateinit var binding : FragmentArchiveBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArchiveBinding.inflate(inflater, container, false)
        val recyclerView = binding.recyclerView

        val items = listOf(
            CountryListDto(JobListType.HEADER_VIEW, "Designer"),
            CountryListDto(JobListType.JOB_VIEW, "Junior UX Designer"),
            CountryListDto(JobListType.JOB_VIEW, "Junior Product Designer"),
            CountryListDto(JobListType.HEADER_VIEW, "Android"),
            CountryListDto(JobListType.JOB_VIEW, "Junior Android Developer"),
            CountryListDto(JobListType.JOB_VIEW, "Senior Android Developer"),
            CountryListDto(JobListType.HEADER_VIEW, "IOS"),
            CountryListDto(JobListType.JOB_VIEW, "Junior IOS Developer"),
            CountryListDto(JobListType.JOB_VIEW, "Senior IOS Developer"),
            CountryListDto(JobListType.HEADER_VIEW, "Backend developer"),
            CountryListDto(JobListType.JOB_VIEW, "Junior Java Developer"),
            CountryListDto(JobListType.JOB_VIEW, "Middle .NET Developer"),
            CountryListDto(JobListType.HEADER_VIEW, "QA Engineer"),
            CountryListDto(JobListType.JOB_VIEW, "Junior QA Engineer"),
            CountryListDto(JobListType.JOB_VIEW, "Strong Junior QA Engineer")

        )
        val adapter = ItemAdapter(items)

        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration()



        return binding.root
    }


}
