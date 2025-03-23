package com.example.apicaller

import com.google.gson.annotations.SerializedName

class Video {

    @SerializedName("title")
    var title:String?=null

    @SerializedName("small_poster")
    var smallPoster:String?=null
}