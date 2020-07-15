package com.addymac.mvp.models

import com.google.gson.annotations.SerializedName

data class Game(
    var id: String,
    var name: String,

    @SerializedName("box_art_url")
    var box_url: String
)