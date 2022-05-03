package com.sumin.news.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sumin.news.databinding.FragmentScrapDirBinding


class ScrapDirFragment : Fragment() {


    private var _binding: FragmentScrapDirBinding? = null
    private val binding: FragmentScrapDirBinding = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScrapDirBinding.inflate(inflater, container, false)
        return binding.root
    }

}