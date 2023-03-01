package com.dev0kch.tabari.view.soura

import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dev0kch.tabari.R
import com.dev0kch.tabari.databinding.ActivityTafsirBinding
import com.dev0kch.tabari.model.entity.Soura
import com.dev0kch.tabari.vm.SouraVM
import java.lang.Math.abs


class TafsirActivity : AppCompatActivity() {

    lateinit var binding: ActivityTafsirBinding
    lateinit var souraVM: SouraVM

    var page = 0
    var nbAya = 0

    var textSize = false
    var bookMark = false
    var readMode = false

    lateinit var soura: Soura
    private lateinit var dialogBox: Dialog
    lateinit var sharedPreferences : SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTafsirBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val souraID:String = intent.getStringExtra("id").toString()
        val ayaNB:String = intent.getStringExtra("ayaNb").toString()
        if (ayaNB != "null"){
            page = ayaNB.toInt()-1
        }

        sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE)
        val myEdit = sharedPreferences.edit()
        var readModeOn: String? = sharedPreferences.getString("readModeON", "")
        val textSizeUP: String? = sharedPreferences.getString("textSizeUP", "")
        val bookMarkON: String? = sharedPreferences.getString("bookMarkON","")
        if (readModeOn.equals("YES")){
            window.statusBarColor = ContextCompat.getColor(this, R.color.eya_mode)
            binding.constraintTafsir.setBackgroundColor(resources.getColor( R.color.eya_mode))
            window.navigationBarColor = ContextCompat.getColor(this, R.color.eya_mode)

            Glide.with(this).load(R.drawable.ic_shield_green).into(binding.btnReadMode)

            readMode = true
        }

        if (textSizeUP.equals("YES")){
            binding.souraTafsir.textSize = 16F
            textSize = true
            Glide.with(this).load(R.drawable.ic_search_green).into(binding.textSize)
        }

        if (bookMarkON.equals("YES")) {
            Glide.with(this).load(R.drawable.ic_bookmark_checked).into(binding.bookmark)
            bookMark = true
        }


        souraVM = SouraVM()

        binding.btnReadMode.setOnClickListener {
            if (!readMode){
                window.statusBarColor = ContextCompat.getColor(this, R.color.eya_mode)
                binding.constraintTafsir.setBackgroundColor(resources.getColor( R.color.eya_mode))
                window.navigationBarColor = ContextCompat.getColor(this, R.color.eya_mode)
                Glide.with(this).load(R.drawable.ic_shield_green).into(binding.btnReadMode)
                readMode = true
                myEdit.putString("readModeON", "YES");
                myEdit.commit()
                readModeOn = "YES"


            }
            else
            {
                window.statusBarColor = ContextCompat.getColor(this, R.color.default_color)
                binding.constraintTafsir.setBackgroundColor(resources.getColor( R.color.default_color))
                window.navigationBarColor = ContextCompat.getColor(this, R.color.default_color)
                Glide.with(this).load(R.drawable.ic_shield).into(binding.btnReadMode)
                myEdit.putString("readModeON", "NO");
                readModeOn = "NO"
                myEdit.commit()
                readMode = false

            }

        }

        souraVM.souraRepo.getSouraByName(souraID+".json", this).observe(this, Observer {
            soura = it
            nbAya= it.ayets!!.size
            displayData()
            }
        )



        binding.menu.setOnClickListener {
            this.dialogBox = Dialog(this,android.R.style.Theme_DeviceDefault_NoActionBar_Fullscreen)
            this.dialogBox.setContentView(R.layout.ayet_alert)
            val window: Window = dialogBox.getWindow()!!
            val wlp = window.attributes
            wlp.windowAnimations = R.style.MyDialogAnimation
            wlp.flags = wlp.flags and WindowManager.LayoutParams.FLAG_DIM_BEHIND.inv()
            window.attributes = wlp

            val ayetAdapter = AyetAdapter(this, soura.ayets!!, this, souraID,  readModeOn.equals("YES"))
            val rcAyet: RecyclerView = this.dialogBox.findViewById(R.id.re_ayet)
            rcAyet.layoutManager = LinearLayoutManager(this)
            rcAyet.adapter = ayetAdapter
            if (readModeOn.equals("YES")){

                val alert : ConstraintLayout= this.dialogBox.findViewById(R.id.alert_constraint)
                alert.setBackgroundColor(Color.parseColor("#23000000"))
                readMode = true
            }
            dialogBox.show()
            val closeRecyclerViewOfAyet : ImageView= this.dialogBox.findViewById(R.id.icon_back)


            closeRecyclerViewOfAyet?.setOnClickListener {
                dialogBox.dismiss()
            }

        }


        binding.textSize.setOnClickListener {
            if (!textSize){
                binding.souraTafsir.textSize = 17F
                textSize = true
                Glide.with(this).load(R.drawable.ic_search_green).into(binding.textSize)
                myEdit.putString("textSizeUP", "YES");
                myEdit.commit()

            }
            else{
                binding.souraTafsir.textSize = 15F
                textSize = false
                Glide.with(this).load(R.drawable.ic_search).into(binding.textSize)
                myEdit.putString("textSizeUP", "NO");
                myEdit.commit()
            }
        }

        binding.bookmark.setOnClickListener {

            if (!bookMark){
                Glide.with(this).load(R.drawable.ic_bookmark_checked).into(binding.bookmark)
                myEdit.putString("bookMarkON", "YES")
                myEdit.putString("souraID",souraID)
                myEdit.putString("aya", page.toString())
                myEdit.commit();
                bookMark = true
            }else
            {
                Glide.with(this).load(R.drawable.ic_bookmark).into(binding.bookmark)
                myEdit.putString("bookMarkON", "NO")
                Toast.makeText(this, "تم حدف علامة المواصلة",Toast.LENGTH_LONG).show()
                myEdit.commit();
                bookMark = false
            }
        }


        binding.constraintTafsir.setOnTouchListener(object : OnSwipeTouchListener(this) {
            override fun onSwipeLeft() {
                super.onSwipeLeft()
                if (page!=0){
                    page--
                    displayData()

                binding.constraintTafsir.scrollTo(0,0)

                }




            }



            override fun onSwipeRight() {
                super.onSwipeRight()
                if (page<nbAya-1){
                    page ++
                    displayData()
                    binding.constraintTafsir.scrollTo(0,0)

                }



            }
        })





    }

    private fun displayData(){

            binding.souraTafsir.text = soura.ayets!!.get(page).tafsir
            binding.souraNameTafsir.text = soura.name
            binding.aleya.text = soura.ayets!!.get(page).eya

            binding.nbEya.text = ("${page+1}/$nbAya")

    }




}


internal open class OnSwipeTouchListener(c: Context?) :
    View.OnTouchListener {
    private val gestureDetector: GestureDetector
    override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
            return gestureDetector.onTouchEvent(motionEvent)
    }
    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {
        private val SWIPE_THRESHOLD: Int = 100
        private val SWIPE_VELOCITY_THRESHOLD: Int = 100
        override fun onDown(e: MotionEvent): Boolean {
            return true
        }
        override fun onSingleTapUp(e: MotionEvent): Boolean {
            onClick()
            return super.onSingleTapUp(e)
        }
        override fun onDoubleTap(e: MotionEvent): Boolean {
            onDoubleClick()
            return super.onDoubleTap(e)
        }
        override fun onLongPress(e: MotionEvent) {
            onLongClick()
            super.onLongPress(e)
        }
        override fun onFling(
            e1: MotionEvent,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            try {
                val diffY = e2.y - e1.y
                val diffX = e2.x - e1.x
                if (abs(diffX) > abs(diffY)) {
                    if (abs(diffX) > SWIPE_THRESHOLD && abs(
                            velocityX
                        ) > SWIPE_VELOCITY_THRESHOLD
                    ) {
                        if (diffX > 0) {
                            onSwipeRight()
                        }
                        else {
                            onSwipeLeft()
                        }
                    }
                }
                else {
                    if (abs(diffY) > SWIPE_THRESHOLD && abs(
                            velocityY
                        ) > SWIPE_VELOCITY_THRESHOLD
                    ) {
                        if (diffY < 0) {
                            onSwipeUp()
                        }
                        else {
                            onSwipeDown()
                        }
                    }
                }
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
            return false
        }
    }
    open fun onSwipeRight() {}
    open fun onSwipeLeft() {}
    open fun onSwipeUp() {}
    open fun onSwipeDown() {}
    private fun onClick() {}
    private fun onDoubleClick() {}
    private fun onLongClick() {}
    init {
        gestureDetector = GestureDetector(c, GestureListener())
    }
}


