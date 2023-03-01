package com.dev0kch.tabari.view.jouza

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dev0kch.tabari.R
import com.dev0kch.tabari.view.MainActivity
import com.dev0kch.tabari.view.soura.SowarAfterFilterFragment
import com.dev0kch.tabari.view.soura.SowarFragment


class JouzaAdapter(val context: Context,val mainActivity: MainActivity) : RecyclerView.Adapter<JouzaAdapter.ViewHolder>(){

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(soura: Int){
            view.findViewById<TextView>(R.id.soura_id).text = convertNumberToArabicNB((soura+1).toString())
            view.findViewById<TextView>(R.id.joz2a_name).text = ("الجُزْء " + convertNumberToArabicNB((position+1).toString()))

            view.setOnClickListener {
                mainActivity.replaceFragment(SowarAfterFilterFragment(soura+1), "SOURA_FILTER")
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.jouza_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
        }

    override fun getItemCount(): Int {
        return 30
    }

    private fun convertNumberToArabicNB(str: String): String {
        val arabic_zero_unicode = 1632

        val builder = StringBuilder()

        for (i in 0 until str.length) {
            builder.append((str[i].code - 48 + arabic_zero_unicode).toChar())
        }

       return builder.toString()
    }

}