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
import java.util.*


//Code -> Convert JavaFile to Kotlin File


class Ch13_Typealias : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var aInner :AInner = A().Inner()
        var sSet : SSet = setOf()
        var jgMap : JGMap<String> = mutableMapOf()

        var predicate : Predicate<Int> = {it >0 }
        println(foo(predicate))

        var handler :Handler = {i,s,any -> println(i.toString()+s+any.toString())}
        foo2(handler)

    }


}

class A{

    inner class Inner
}

typealias AInner = A.Inner
typealias SSet = Set<String>
typealias JGMap<T> = MutableMap<T,MutableList<String >>
typealias Predicate<T> = (T) -> Boolean

fun foo(predicate : Predicate<Int>)= predicate(10 )

typealias Handler = (Int,String,Any) -> Unit
fun foo2(handler :Handler) = handler(1,"JG",27)