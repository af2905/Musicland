package com.github.af2905.musicland.data.network

import com.github.af2905.musicland.data.network.interceptor.HttpHeaderInterceptor
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

const val DEFAULT_TIMEOUT = 30L
const val MAX_IDLE_CONNECTION = 5
const val KEEP_ALIVE_DURATION = 30L

class OkHttpClientHelper(
    private val httpLoggingInterceptor: HttpLoggingInterceptor,
    private val httpHeaderInterceptor: HttpHeaderInterceptor
) : OkHttpClient() {

    fun provideOkHttpClient(): OkHttpClient {
        return Builder()
            .connectionPool(
                ConnectionPool(MAX_IDLE_CONNECTION, KEEP_ALIVE_DURATION, TimeUnit.SECONDS)
            )
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            //.addInterceptor(httpHeaderInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }
}