package com.example.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclerview.databinding.FragmentArchiveBinding
import com.example.recyclerview.databinding.FragmentSplashScreenBinding


class ArchiveFragment : Fragment() {
    private lateinit var binding : FragmentArchiveBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArchiveBinding.inflate(inflater, container, false)

        return binding.root
    }


}
