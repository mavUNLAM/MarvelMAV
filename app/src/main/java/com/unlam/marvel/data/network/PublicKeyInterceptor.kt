package com.unlam.marvel.data.network

import com.unlam.marvel.data.PUBLIC_KEY
import okhttp3.Interceptor
import okhttp3.Response
/*
se usa en val okHttpClient = OkHttpClient.Builder()
.addInterceptor(PublicKeyInterceptor())
.build()
*/
class PublicKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url()

        val newUrl = url.newBuilder()
            .addQueryParameter("apikey", PUBLIC_KEY)
            .build()

        return chain.proceed(
            request.newBuilder()
                .url(newUrl)
                .build()
        )
    }
}