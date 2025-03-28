package com.example.apicaller

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val videoAdapter = VideoAdapter()
        recyclerView.adapter = videoAdapter

        val videoService = getRetrofit().create(VideoService::class.java)

        val callVideoList = videoService.getVideoList()

        callVideoList.enqueue(object : Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {

                val movies = response.body()

                if (movies != null) {
                    videoAdapter.loadedState(movies.videoList)

                    Log.d("tagA", "onResponse: ${movies.videoList?.get(0)!!.title}")
                }

            }

            override fun onFailure(call: Call<Movies>, err: Throwable) {
                Log.d("tagA", "onFailure: ${err.message}")
            }

        })


    }

    private fun getRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.aparat.com/etc/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

}
