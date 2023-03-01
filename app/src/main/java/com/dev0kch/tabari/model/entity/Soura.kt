package com.dev0kch.tabari.model.entity

data class Soura(
    val id: String,
    val name: String,
    val type : String,
    val nbAya : Int,
    val joz2a : Int,
    val ayets: ArrayList<Eya>? = arrayListOf(),

    )

