package com.leonamleite.marvelapi.networking.clients

import com.leonamleite.marvelapi.networking.interceptors.MarvelInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class GeneralApiClient(
    private val base_url: String
) : ApiClient() {

    override fun baseUrl() : String = base_url

    override fun generateClient(): OkHttpClient {
        val builder = OkHttpClient()
            .newBuilder()
            .addInterceptor(MarvelInterceptor())
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)

        return builder.build()
    }
}