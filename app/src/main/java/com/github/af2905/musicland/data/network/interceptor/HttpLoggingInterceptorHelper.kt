package com.github.af2905.musicland.data.network.interceptor

import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

class HttpLoggingInterceptorHelper(
    private val httpLoggerInterceptor: HttpLoggerInterceptor
) {

    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(httpLoggerInterceptor)
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}

object HttpLoggerInterceptor : HttpLoggingInterceptor.Logger {
    override fun log(message: String) = Timber.tag("OkHttp").d(message)
}
