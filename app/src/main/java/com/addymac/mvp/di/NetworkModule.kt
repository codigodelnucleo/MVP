package com.addymac.mvp.di

import com.addymac.mvp.network.TwichAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {
    private val BASE_URL="https://jsonplaceholder.typicode.com/"


    @Provides
    fun provideOkhttpClient() : OkHttpClient {
       var interceptor =  HttpLoggingInterceptor()
           interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return  OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    fun provideRetrofit(baseURL: String, okHttpClient: OkHttpClient): Retrofit{
       return Retrofit.Builder()
            .baseUrl(baseURL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideTwitchAPI(): TwichAPI {
        return  provideRetrofit(BASE_URL,provideOkhttpClient()).create(TwichAPI::class.java)
    }
}