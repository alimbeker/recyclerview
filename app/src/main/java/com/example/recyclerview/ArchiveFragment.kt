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


        val adapter = ItemAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = adapter
        val data = listOf(
            Item(1, "Junior UX Designer"),
            Item(2, "Junior Android Developer"),
            Item(3, "Middle motion designer")
        )
        adapter.submitList(data)

        return binding.root
    }


}
