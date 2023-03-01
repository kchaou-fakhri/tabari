package com.dev0kch.tabari.model.data.local

import android.content.Context
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dev0kch.tabari.R
import com.dev0kch.tabari.model.entity.Soura
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class SouraLocal {
    
    val makia ="مكيَّة"
   val madania = "مدنيَّة"


     val listSoura = arrayListOf<Soura>(
        Soura("1","الْفَاتِحَة",makia,7,1),
        Soura("2", "البَقَرَة", madania,286,2),
        Soura("3","آل عِمرَان", madania,200,4),
        Soura("4","النِّسَاء", madania, 176,5),
        Soura("5","المَائدة",madania, 120,7),
        Soura("6","الأنعَام",makia, 165	,8),
        Soura("7","الأعرَاف",makia, 206,9),
        Soura("8","الأنفَال",madania, 75,10),
        Soura("9","التوبَة",madania, 129,11),
        Soura("10","يُونس",makia, 109,12),
        Soura("11","هُود",makia, 123,12),
        Soura("12","يُوسُف",makia, 111,13),
        Soura("13","الرَّعْد",makia, 43, 13),
        Soura("14","إبراهِيم",makia, 52, 13),
        Soura("15","الحِجْر",makia, 99, 14),
        Soura("16","النَّحْل",makia, 128, 14),
        Soura("17","الإسْرَاء",makia, 111, 15),
        Soura("18","الكهْف",makia, 110, 16),
        Soura("19","مَريَم",makia, 98, 16),
        Soura("20","طه",makia, 135, 16),
        Soura("21","الأنبيَاء",makia, 112, 17),
        Soura("22","الحَج",makia, 78, 17),
        Soura("23","المُؤمنون",makia, 118,18),
        Soura("24","النُّور",madania, 64, 18),
        Soura("25","الفُرْقان",makia, 77, 19),
        Soura("26","الشُّعَرَاء",makia, 227, 19),
        Soura("27","النَّمْل",makia, 93, 20),
        Soura("28","القَصَص",makia, 88, 20),
        Soura("29","العَنكبوت",makia, 69, 21),
        Soura("30","الرُّوم",makia, 60, 21),
        Soura("31","لقمَان",makia, 34, 21),
        Soura("32","السَّجدَة",makia, 30, 21),
        Soura("33","الأحزَاب",madania, 73, 22),
        Soura("34","سَبَأ",makia, 54, 22),
        Soura("35","فَاطِر",makia, 45, 22),
        Soura("36","يس",makia, 83, 23),
        Soura("37","الصَّافات",makia, 182, 23),
        Soura("38","ص",makia, 88, 23),
        Soura("39","الزُّمَر",makia, 75, 24),
        Soura("40","غَافِر",makia, 85, 24),
        Soura("41","فُصِّلَتْ",makia, 54, 25),
        Soura("42","الشُّورَى",makia, 53, 25),
        Soura("43","الزُّخْرُف",makia, 89, 25),
        Soura("44","الدُّخان",makia, 59,25),
        Soura("45","الجاثِية",makia, 37,25),
        Soura("46","الأحقاف",makia, 35, 26),
        Soura("47","مُحَمّد",madania, 38, 26),
        Soura("48","الفَتْح",madania, 29, 26),
        Soura("49","الحُجُرات",madania, 18,26),
        Soura("50","ق",makia, 0, 45),
        Soura("51","الذَّاريَات",makia, 60, 27),
        Soura("52","الطُّور",makia, 49, 27),
        Soura("53","النَّجْم",makia, 62, 27),
        Soura("54","القَمَر",makia, 55,27),
        Soura("55","الرَّحمن",makia, 78, 27),
        Soura("56","الواقِعَة",makia, 96, 27),
        Soura("57","الحَديد",madania, 29, 27),
        Soura("58","المُجادَلة",madania, 22, 28),
        Soura("59","الحَشْر",madania, 24, 28),
        Soura("60","المُمتَحَنة",madania, 13, 28),
        Soura("61","الصَّف",makia, 14, 28),
        Soura("62","الجُّمُعة",madania, 11,28),
        Soura("63","المُنافِقُون",madania, 11, 28),
        Soura("64","التَّغابُن",makia, 18, 28),
        Soura("65","الطَّلاق",madania, 12, 28),
        Soura("66","التَّحْريم",madania, 12, 28),
        Soura("67","المُلْك",makia, 30,29),
        Soura("68","القَلـََم",makia, 52, 29),
        Soura("69","الحَاقّـَة",makia, 52, 29),
        Soura("70","المَعارِج",makia, 44, 29),
        Soura("71","نُوح",makia, 28, 29),
        Soura("72","الجِنّ",makia, 28, 29),
        Soura("73","المُزَّمّـِل",makia, 20, 29),
        Soura("74","المُدَّثــِّر",makia, 56, 29),
        Soura("75","القِيامَة",makia, 40, 29),
        Soura("76","الإنسان",makia, 31, 29),
        Soura("77","المُرسَلات",makia, 50, 29),
        Soura("78","النـَّبأ",makia, 40, 30),
        Soura("79","النـّازِعات",makia, 46, 30),
        Soura("80","عَبَس", makia, 42, 30),
        Soura("81","التـَّكْوير",makia, 29, 30),
        Soura("82","الإنفِطار",makia, 19, 30),
        Soura("83","المُطـَفِّفين",makia, 36, 30),
        Soura("84","الإنشِقاق",makia, 25, 30),
        Soura("85","البُروج",makia, 22, 30),
        Soura("86","الطّارق",makia, 17, 30),
        Soura("87","الأعلی",makia, 19, 30),
        Soura("88","الغاشِيَة",makia, 26, 30),
        Soura("89","الفَجْر",makia, 30, 30),
        Soura("90","البَـلـَد",makia, 20, 30),
        Soura("91","الشــَّمْس",makia, 15, 30),
        Soura("92","اللـَّيل",makia, 21, 30),
        Soura("93","الضُّحی",makia, 11, 30),
        Soura("94","الشَّرْح",makia, 8, 30),
        Soura("95","التـِّين",makia, 8, 30),
        Soura("96","العَلـَق",makia, 19, 30),
        Soura("97","القـَدر",makia, 5, 30),
        Soura("98","البَيِّنَة",makia, 8, 30),
        Soura("99","الزلزَلة",makia, 8, 30),
        Soura("100","العَادِيات",makia, 11, 30),
        Soura("101","القارِعَة",makia, 11, 30),
        Soura("102","التَكاثـُر",makia, 8, 30),
        Soura("103","العَصْر",makia, 3, 30),
        Soura("104","الهُمَزَة",makia, 9, 30),
        Soura("105","الفِيل",makia, 5, 30),
        Soura("106","قـُرَيْش",makia, 4, 30),
        Soura("107","المَاعُون",makia, 7,30),
        Soura("108","الكَوْثَر",makia, 3, 30),
        Soura("109","الكَافِرُون",makia, 6, 30),
        Soura("110","النـَّصر",madania, 3, 30),
        Soura("111","المَسَد",makia, 5, 30),
        Soura("112","الإخْلَاص",makia,4,30),
        Soura("113","الفَلَق",makia, 5, 30),
        Soura("114","النَّاس",makia, 6, 30),


    )


   fun getAll() : LiveData<ArrayList<Soura>>{
      val mutableLiveData = MutableLiveData<ArrayList<Soura>>()
      mutableLiveData.value = listSoura
      return mutableLiveData
   }

    fun getSouraByName(name : String, context: Context) : LiveData<Soura>{

        var mutableLiveData = MutableLiveData<Soura>()

        val jsonFileString = getJsonDataFromAsset( name, context)
        val gson = Gson()
        val souraOb = object : TypeToken<Soura>() {}.type

        var soura : Soura = gson.fromJson(jsonFileString, souraOb)

        mutableLiveData.value = soura

        return mutableLiveData

    }


    fun getJsonDataFromAsset(fileName: String, context : Context): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun getSouraBySouzaID(jouzaID: Int): List<Soura> {
        return listSoura.filter {
            it.joz2a.equals(jouzaID)
        }

    }

}