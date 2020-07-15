package com.addymac.mvp.network

import com.addymac.mvp.models.Post
import retrofit2.Call
import retrofit2.http.GET

interface TwichAPI {

   @GET("posts")
   fun getAllPosts() : Call<List<Post>>

}