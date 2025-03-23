package com.example.apicaller

import com.google.gson.annotations.SerializedName

class Movies {

    @SerializedName("mostviewedvideos")
    var videoList: ArrayList<Video>? = null;

}