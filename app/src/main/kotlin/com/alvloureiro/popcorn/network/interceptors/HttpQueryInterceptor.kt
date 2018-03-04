package com.alvloureiro.popcorn.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response


class HttpQueryInterceptor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        val original = chain?.request()
        val originalHttpUrl = original?.url()

        val url = originalHttpUrl?.newBuilder()
                ?.addQueryParameter("api_key", "1f54bd990f1cdfb230adb312546d765d")
                ?.build()

        val requestBuilder = original?.newBuilder()
                ?.url(url)

        val request = requestBuilder?.build()
        return chain?.proceed(request)!!
    }
}
