package com.dev0kch.tabari.view.soura

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dev0kch.tabari.R
import com.dev0kch.tabari.model.entity.Eya


class AyetAdapter(
    val context: Context,
    val listEya: ArrayList<Eya>,
    val tafsirActivity: TafsirActivity,
    val souraID: String,
    val mode: Boolean
) : RecyclerView.Adapter<AyetAdapter.ViewHolder>(){

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(eya: Eya){
            view.findViewById<TextView>(R.id.aya_id).text = convertNumberToArabicNB(eya.id.toString())
            view.findViewById<TextView>(R.id.aya).text = eya.eya
            if (mode){
                view.findViewById<TextView>(R.id.aya).setTextColor(context.getColor(R.color.default_color))

            }


            view.setOnClickListener {
                val intent = Intent(context, TafsirActivity::class.java)
                intent.putExtra("ayaNb", eya.id.toString())
                intent.putExtra("id", souraID)
                tafsirActivity.finish()

                context.startActivity(intent)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.aya_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listEya[position])
    }

    override fun getItemCount(): Int {
        return listEya.size
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