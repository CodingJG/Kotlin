package com.gmp.mac.kotlinproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Locale.filter


//Code -> Convert JavaFile to Kotlin File

class MainActivity : AppCompatActivity() {

    var value: String? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        //if문으로 null 체크.
        if(value != null){
            textView_main.text = value?.length.toString()
        }
        */

        //체크용 값.
        //value = "Test"

        //let을 이용한 null 체크.
        value?.let{ textView_main.text = it.length.toString()}

    }




}
