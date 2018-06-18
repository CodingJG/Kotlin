package com.gmp.mac.kotlinproject

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



//Code -> Convert JavaFile to Kotlin File


class Ch10_Coroutine : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        launch { // launch new coroutine in background and continue
            delay(5000L) // non-blocking delay for 1 second (default time unit is ms)
            println("World!") // print after delay
        }
        println("Hello,") // main thread continues while coroutine is delayed
        Thread.sleep(10000L) // block main thread for 2 seconds to keep JVM alive

        */


        var one = async { doSomethingUsefulOne() }
        var two = async { doSomethingUsefulTwo() }

        runBlocking { println(one.await()  +  two.await()) };

    }


    suspend fun doSomethingUsefulOne(): Int{
        delay(5000L)
        return 13;
    }

    suspend fun doSomethingUsefulTwo(): Int{
        delay(10000L)
        return 29;
    }



}
