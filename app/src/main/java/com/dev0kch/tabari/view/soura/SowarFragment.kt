package com.dev0kch.tabari.view.soura

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev0kch.tabari.databinding.FragmentSowarBinding
import com.dev0kch.tabari.vm.SouraVM


class SowarFragment : Fragment() {

    lateinit var _binding : FragmentSowarBinding
    val binding get() = _binding
    lateinit var souraVM: SouraVM



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSowarBinding.inflate(inflater, container, false)

        souraVM = SouraVM()
        val customLinearLayoutManager = object : LinearLayoutManager(requireContext()) { override fun canScrollVertically() = false }


        souraVM.souraRepo.souraLocal.getAll().observe(viewLifecycleOwner, Observer {
            val souraAdapter = SouraAdapter(requireContext(), it)
            binding.qor2enList.layoutManager = customLinearLayoutManager
            binding.qor2enList.adapter = souraAdapter

        })




        return binding.root
    }


}