package com.dev0kch.tabari.view

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dev0kch.tabari.R
import com.dev0kch.tabari.databinding.ActivityMainBinding
import com.dev0kch.tabari.view.jouza.JouzaFragment
import com.dev0kch.tabari.view.soura.SowarFragment
import com.dev0kch.tabari.view.soura.TafsirActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var sowarFragment: SowarFragment
    lateinit var jouzaFragment: JouzaFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        sowarFragment = SowarFragment()
        jouzaFragment = JouzaFragment(this)

        binding.joz2a.setOnClickListener {
            binding.soura.setBackgroundColor(this.resources.getColor(R.color.gary_200));
            binding.soura.setTextColor(resources.getColor(R.color.text_color))


            binding.btnBookmark.setBackgroundColor(this.resources.getColor(R.color.gary_200));
            binding.btnBookmark.setTextColor(resources.getColor(R.color.text_color))

            binding.joz2a.setBackgroundColor(resources.getColor(R.color.primary_color))
            binding.joz2a.setTextColor(Color.WHITE)

            replaceFragment(jouzaFragment, "JOUZA")


        }


        binding.soura.setOnClickListener {
            binding.soura.setBackgroundColor(this.resources.getColor(R.color.primary_color));
            binding.soura.setTextColor(Color.WHITE)

            binding.btnBookmark.setBackgroundColor(this.resources.getColor(R.color.gary_200));
            binding.btnBookmark.setTextColor(resources.getColor(R.color.text_color))

            binding.joz2a.setBackgroundColor(this.resources.getColor(R.color.gary_200))
            binding.joz2a.setTextColor(resources.getColor(R.color.text_color))

            replaceFragment(sowarFragment, "SOURA")



        }

        binding.btnBookmark.setOnClickListener {
            binding.soura.setBackgroundColor(this.resources.getColor(R.color.gary_200))
            binding.soura.setTextColor(resources.getColor(R.color.text_color))

            binding.btnBookmark.setBackgroundColor(this.resources.getColor(R.color.primary_color));
            binding.btnBookmark.setTextColor(Color.WHITE)

            binding.joz2a.setBackgroundColor(this.resources.getColor(R.color.gary_200))
            binding.joz2a.setTextColor(resources.getColor(R.color.text_color))


            var sharedPreferences : SharedPreferences =
                getSharedPreferences("settings", MODE_PRIVATE)

            val bookMarkON: String? = sharedPreferences.getString("bookMarkON","")
            if (bookMarkON.equals("YES")) {
                val souraID: String? = sharedPreferences.getString("souraID","")
                    val aya: String? = sharedPreferences.getString("aya","")

                    var _aya = aya?.toInt()?.plus(1)
                val intent = Intent(this, TafsirActivity::class.java)
                intent.putExtra("id",souraID)
                intent.putExtra("ayaNb",_aya.toString() )
                this.startActivity(intent)
            }
            else{
                Toast.makeText(this, "لا توجد علامة مواصلة", Toast.LENGTH_LONG)
                    .show()

            }

        }

        replaceFragment(sowarFragment, "SOURA")



    }


     fun replaceFragment(fragment: Fragment, tag : String) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_manager, fragment,tag )
        transaction.commit()
    }

    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.fragments.last().tag

        if (currentFragment.equals("SOURA_FILTER")){
            replaceFragment(JouzaFragment(this), "JOUZA")
        }else
        if (currentFragment.equals("JOUZA")){
            replaceFragment(SowarFragment(), "SOURA")

            binding.soura.setBackgroundColor(this.resources.getColor(R.color.primary_color));
            binding.soura.setTextColor(Color.WHITE)

            binding.btnBookmark.setBackgroundColor(this.resources.getColor(R.color.gary_200));
            binding.btnBookmark.setTextColor(resources.getColor(R.color.text_color))

            binding.joz2a.setBackgroundColor(this.resources.getColor(R.color.gary_200))
            binding.joz2a.setTextColor(resources.getColor(R.color.text_color))

        }
        else{
            super.onBackPressed()

        }
    }


}