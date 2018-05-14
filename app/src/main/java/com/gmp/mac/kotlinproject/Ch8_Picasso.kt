package com.gmp.mac.kotlinproject

import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import com.gmp.mac.kotlinproject.Ch7_DataModel.PapagoDTO
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_picasso.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException


//Code -> Convert JavaFile to Kotlin File

class Ch8_Picasso : AppCompatActivity() {

    //implementation 'com.squareup.picasso:picasso:2.71828'
    //implementation 'com.android.support:recyclerview-v7:27.1.1'

    val imageUrls = arrayOf(
            "https://images.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg?auto=compress&cs=tinysrgb&h=350",
            "https://images.pexels.com/photos/35807/rose-red-rose-romantic-rose-bloom.jpg?auto=compress&cs=tinysrgb&h=350",
            "https://images.pexels.com/photos/56866/garden-rose-red-pink-56866.jpeg?auto=compress&cs=tinysrgb&h=350",
            "https://images.pexels.com/photos/86243/pexels-photo-86243.jpeg?auto=compress&cs=tinysrgb&h=350"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso)


        recyclerView.adapter = MyRecyclerviewAdapter()
        recyclerView.layoutManager = GridLayoutManager(this,2)

    }

    inner class MyRecyclerviewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
           var imageView = ImageView(this@Ch8_Picasso)
            var params = LinearLayout.LayoutParams(parent!!.measuredWidth/2,parent!!.measuredHeight/2)
            imageView.layoutParams = params
            imageView.scaleType = ImageView.ScaleType.FIT_XY
            return CustomHolder(imageView)
        }

        inner class CustomHolder(imageView: ImageView):RecyclerView.ViewHolder(imageView){

        }

        override fun getItemCount(): Int {
            return imageUrls.size
        }


        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
          Picasso.get().load(imageUrls[position]).into(holder!!.itemView as ImageView)
        }

    }



}
