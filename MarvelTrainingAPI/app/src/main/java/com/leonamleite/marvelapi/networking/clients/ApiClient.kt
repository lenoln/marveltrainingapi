package com.leonamleite.marvelapi.networking.clients

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class ApiClient {

    companion object {
        const val TIMEOUT = 10L
    }

    abstract fun generateClient(): OkHttpClient
    abstract fun baseUrl(): String

    private val okHttpClient: OkHttpClient by lazy { generateClient() }

    fun cancelRequests() {
        okHttpClient.dispatcher.cancelAll()
    }

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl())
            .client(okHttpClient)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

}