package com.alvloureiro.popcorn.network.interceptors

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response


class HttpQueryInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        val original = chain?.request()
        val originalHttpUrl = original?.url()

        val url: HttpUrl = originalHttpUrl?.newBuilder()
                ?.addQueryParameter("api_key", "")
                ?.build()!!

        val requestBuilder = original.newBuilder()
                ?.url(url)

        val request = requestBuilder?.build()!!
        return chain.proceed(request)
    }
}
