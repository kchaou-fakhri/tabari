package com.dev0kch.tabari.vm

import android.content.Context
import androidx.lifecycle.LiveData
import com.dev0kch.tabari.model.entity.Soura
import com.dev0kch.tabari.model.repository.SouraRepo

class SouraVM {

    val souraRepo = SouraRepo()

    fun getSouraByName(name :String, context : Context) : LiveData<Soura> {
        return souraRepo.getSouraByName(name, context )
    }
}