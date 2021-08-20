package com.github.af2905.musicland.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class HttpHeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        request.newBuilder().addHeader(
            name = "Authorization",
            value = "Bearer BQBhqFTHQomRFUnJoWyOHqaOGeyi-4Td5sZg_Vg2w9X5Pho_dz-g80hueZEbo5hJItP4KN-EVYVr80bPcuJoDGiS7l-A6ZZKIOaFFa_VJ7Hsq8obS1Fq6KINV1j1_OWZ5KfKgG1ksWoEgzgAYCsFR_MlRKLFkvKfvf3IOv9LLQusJ4iFT79lXEOVH7n3vFPT"
        )
            .build()
        return chain.proceed(request)
    }
}