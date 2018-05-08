package com.gmp.mac.kotlinproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class Ch1_findViewById : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Ch1
        findViewByIdTest()
    }

    fun findViewByIdTest(){

        //apply plugin: 'kotlin-android-extensions'
        btn_main.setOnClickListener(){textView_main.text = editText_main.text};

        //findViewById
        var textView = findViewById<TextView>(R.id.textView_main);
    }
}