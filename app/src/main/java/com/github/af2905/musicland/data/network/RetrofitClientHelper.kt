package com.github.af2905.musicland.data.network

import com.github.af2905.musicland.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClientHelper(
    private val okHttpClient: OkHttpClient
) {

    fun provideRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .baseUrl(BASE_URL)
            .build()
    }

    companion object {
        const val BASE_URL = "https://api.spotify.com/v1/"
    }
}

