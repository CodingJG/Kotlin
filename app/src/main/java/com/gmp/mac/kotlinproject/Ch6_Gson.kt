package com.gmp.mac.kotlinproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gmp.mac.kotlinproject.Ch6_DataModel.UserDTO
import com.google.gson.Gson


//Code -> Convert JavaFile to Kotlin File

class Ch6_Gson : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       var json = "{ \"name\":\"John\", \"age\":31, \"city\":\"New York\" }";

        var gson = Gson();
        var userDTO = gson.fromJson(json, UserDTO::class.java)

        println(userDTO.name);
        println(userDTO.age.toString())
        println(userDTO.city)
    }



}
