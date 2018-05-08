package com.gmp.mac.kotlinproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle


//Code -> Convert JavaFile to Kotlin File

class Ch3_Sort : AppCompatActivity() {

    var list = mutableListOf<KotlinPerson>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list.add(KotlinPerson("나비",7))
        list.add(KotlinPerson("다리미",2))
        list.add(KotlinPerson("나비",5))
        list.add(KotlinPerson("마법",9))
        list.add(KotlinPerson("바리스타",11))
        list.add(KotlinPerson("알고리즘",14))

        sort();

    }

    fun sort(){

        // = list.sortWith(compareBy({person -> person.name},{person -> person.age}))
        list.sortWith(compareBy({it.name},{it.age}))

        list.forEach{person: KotlinPerson -> println(person.toString())}
    }







}
