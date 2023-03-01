package com.dev0kch.tabari.view.soura

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev0kch.tabari.databinding.FragmentSowarBinding
import com.dev0kch.tabari.model.entity.Soura
import com.dev0kch.tabari.vm.SouraVM


class SowarAfterFilterFragment(var jouzaID : Int) : Fragment() {

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


               if(jouzaID == 3){
            jouzaID =jouzaID-1
        }

        val souraAdapter = SouraAdapter(requireContext(), souraVM.souraRepo.souraLocal.getSouraBySouzaID(jouzaID) as ArrayList<Soura>)
        binding.qor2enList.layoutManager = customLinearLayoutManager
        binding.qor2enList.adapter = souraAdapter




        return binding.root
    }




}