package com.dev0kch.tabari.view.jouza

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev0kch.tabari.databinding.FragmentJouzaBinding
import com.dev0kch.tabari.view.MainActivity
import com.dev0kch.tabari.vm.SouraVM


class JouzaFragment(val mainActivity: MainActivity) : Fragment() {



    lateinit var _binding : FragmentJouzaBinding
    val binding get() = _binding
    lateinit var souraVM : SouraVM
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentJouzaBinding.inflate(inflater, container, false)


        souraVM = SouraVM()
        val customLinearLayoutManager = object : LinearLayoutManager(requireContext()) { override fun canScrollVertically() = false }


        val jouzaAdapter = JouzaAdapter(requireContext(), mainActivity)
        binding.jouzaList.layoutManager = customLinearLayoutManager
        binding.jouzaList.adapter = jouzaAdapter


        return binding.root
    }

}