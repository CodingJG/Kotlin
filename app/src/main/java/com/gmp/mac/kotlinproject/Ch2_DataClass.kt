package com.gmp.mac.kotlinproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gmp.mac.kotlinproject.Ch2_DataModel.JavaPerson

class Ch2_DataClass : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Ch2
        dataModel()
    }

    fun dataModel(){

        //Create Constructor

        var javaPerson = JavaPerson();

        var kotlinPerson = KotlinPerson();

        //Create Constructor + Input Data

        var javaPerson2 = JavaPerson("JGLee",27);

        var kotlinPerson2 = KotlinPerson("JGLee",27);

        //Setter

        javaPerson.setAge(11);
        kotlinPerson.age = 12;

        //Getter

        println(javaPerson.getAge());
        println(kotlinPerson.age!!)

        //toString

        println(javaPerson.toString());
        println(kotlinPerson.toString());


    }
}