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
import okhttp3.*
import org.json.JSONObject
import org.w3c.dom.Text
import java.io.IOException



//Code -> Convert JavaFile to Kotlin File

open class Item : RealmObject(){
    open var name : String? = null
}

class Ch9_Realm : AppCompatActivity() {


    // classpath "io.realm:realm-gradle-plugin:5.1.0"

    //apply plugin: 'kotlin-kapt'
    //apply plugin: 'realm-android'

    var shoppingList = mutableListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        recyclerview_realm.adapter = RcAdapter()
        recyclerview_realm.layoutManager = LinearLayoutManager(this)

        Realm.init(this)
        var config = RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build()

        var realm = Realm.getInstance(config)

        btn_realm.setOnClickListener{
            realm.beginTransaction()
            var item = realm.createObject(Item::class.java)
            item.name = editText_realm.text.toString()
            realm.commitTransaction()
        }

        realm.where(Item::class.java).findAll().addChangeListener {
            t: RealmResults<Item>?, changeSet: OrderedCollectionChangeSet? ->
            shoppingList.clear()
            shoppingList.addAll(t!!)
            recyclerview_realm.adapter.notifyDataSetChanged()
        }


    }


    inner class RcAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

            var textview = TextView(this@Ch9_Realm)
            return CustomViewHolder(textview)
        }

        inner class CustomViewHolder(textview: TextView) : RecyclerView.ViewHolder(textview) {

        }

        override fun getItemCount(): Int {

            return shoppingList.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

            var textView = holder!!.itemView as TextView
            textView.text = shoppingList[position].name

        }

    }


}
