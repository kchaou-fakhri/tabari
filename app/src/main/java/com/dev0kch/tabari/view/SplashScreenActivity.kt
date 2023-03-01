package com.dev0kch.tabari.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.ViewModelProvider
import com.dev0kch.tabari.R
import com.dev0kch.tabari.vm.SouraVM

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed(Runnable {

            val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                this.finish()


        }, 1000)
    }

}