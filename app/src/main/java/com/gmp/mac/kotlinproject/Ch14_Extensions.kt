package com.gmp.mac.kotlinproject

import android.content.Intent
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.gmp.mac.kotlinproject.Ch7_DataModel.PapagoDTO
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import io.realm.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_picasso.*
import kotlinx.android.synthetic.main.activity_realm.*
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import okhttp3.*
import org.json.JSONObject
import org.w3c.dom.Text
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


//Code -> Convert JavaFile to Kotlin File


class Ch14_Extensions : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var date = "2018-06-18 15:50:00".toDay()
        println(date)

        var date2 = "2018-06-18 15:50:00".toTime()
        println(date2)

        var date3 = Date().toDay()
        println(date3)

        var date4 = Date().toTime()
        println(date4)
    }


}

fun String.toDay() :String{

    var parserDateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
    var date = parserDateFormat.parse(this)
    var dateFormat = SimpleDateFormat("yyyy년 MM월 dd일")

    return dateFormat.format(date)
}

fun String.toTime() :String{

    var parserDateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
    var date = parserDateFormat.parse(this)
    var dateFormat = SimpleDateFormat("hh시 mm")

    return dateFormat.format(date)
}

fun Date.toDay():String{

    var dateFormat = SimpleDateFormat("yyyy년 MM월 dd일")

    return dateFormat.format(this)
}

fun Date.toTime():String{

    var dateFormat = SimpleDateFormat("hh시 mm")

    return dateFormat.format(this)
}