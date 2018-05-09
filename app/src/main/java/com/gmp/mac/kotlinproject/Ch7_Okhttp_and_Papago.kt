package com.gmp.mac.kotlinproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gmp.mac.kotlinproject.Ch7_DataModel.PapagoDTO
import com.google.gson.Gson
import okhttp3.*
import org.json.JSONObject
import java.io.IOException


//Code -> Convert JavaFile to Kotlin File

class Ch7_Okhttp_and_Papago : AppCompatActivity() {


    //네이버개발자센터 -> 어플리케이션 등록 -> PapagoNMT번역

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Papago okhttp
        val JSON = MediaType.parse("application/json; charset=utf-8")

        val client = OkHttpClient()
        var url = "https://openapi.naver.com/v1/papago/n2mt";
        var json = JSONObject();
        json.put("source","ko")
        json.put("target","en")
        json.put("text","만나서 반갑습니다.")


        //Api Id,Secret header add
        val body = RequestBody.create(JSON, json.toString())
        val request = Request.Builder()
                .header("X-Naver-Client-Id","AparHsJGIZeOSTE9K37a")
                .addHeader("X-Naver-Client-Secret","5LdrNko0b4")
                .url(url)
                .post(body)
                .build()

        //Callback
        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call?, e: IOException?) {
                println(e.toString());

            }

            override fun onResponse(call: Call?, response: Response?) {

                //Json result
                var str =  response!!.body()!!.string()
                println(str);

                //Papago DTO -> Nice to meet you
                var papagoDTO = Gson().fromJson<PapagoDTO>(str, PapagoDTO::class.java)
                println(papagoDTO.message!!.result!!.translatedText)
            }

        })

    }



}
