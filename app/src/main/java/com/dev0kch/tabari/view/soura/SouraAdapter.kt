package com.dev0kch.tabari.view.soura

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dev0kch.tabari.R
import com.dev0kch.tabari.model.entity.Soura


class SouraAdapter (val context : Context, val listSoura : ArrayList<Soura>) : RecyclerView.Adapter<SouraAdapter.ViewHolder>(){

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(soura :Soura){
            view.findViewById<TextView>(R.id.soura_id).text = convertNumberToArabicNB(soura.id)
            view.findViewById<TextView>(R.id.soura_name).text = soura.name
            view.findViewById<TextView>(R.id.type_soura).text = soura.type
            if(soura.nbAya<=10){
                view.findViewById<TextView>(R.id.nb_eya).text = convertNumberToArabicNB(soura.nbAya.toString())+" أيات"

            }else

                    view.findViewById<TextView>(R.id.nb_eya).text = convertNumberToArabicNB(soura.nbAya.toString())+" أية"

            view.setOnClickListener {
                val ieventreport = Intent(context, TafsirActivity::class.java)
                ieventreport.putExtra("id", soura.id)
                context.startActivity(ieventreport)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.soura_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listSoura[position])
        }

    override fun getItemCount(): Int {
        return listSoura.size
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