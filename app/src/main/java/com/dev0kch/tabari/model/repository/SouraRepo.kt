package com.dev0kch.tabari.model.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.dev0kch.tabari.model.data.local.SouraLocal
import com.dev0kch.tabari.model.entity.Soura

class SouraRepo {

    val souraLocal = SouraLocal()

    fun getSouraByName(name :String, context : Context) : LiveData<Soura>{
        return souraLocal.getSouraByName(name, context )
    }

}