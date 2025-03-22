package com.example.apicaller

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client: OkHttpClient = OkHttpClient()

        val request: Request = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/todos")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("tagA", "onFailure: ${e.message}")
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val jsonString = response.body!!.string()
                    val jsonObject = JSONArray(jsonString)

//                    val userId = jsonObject.getInt("userId")
//                    val id = jsonObject.getInt("id")
//                    val title = jsonObject.getString("title")
//                    val completed = jsonObject.getBoolean("completed")

                    Log.d("tagB", "${jsonObject[0]}")
                } else {
                    Log.d("tagA", "Error: ${response.code}")
                }
            }
        })
    }
}
