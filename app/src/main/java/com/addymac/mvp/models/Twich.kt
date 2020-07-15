package com.addymac.mvp.models

import com.google.gson.annotations.SerializedName

data class Twich(
    @SerializedName("data")
    var games : List<Game>,
    var pagination : Pagination)