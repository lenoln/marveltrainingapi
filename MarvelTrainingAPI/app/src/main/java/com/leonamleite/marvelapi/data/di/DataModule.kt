package com.leonamleite.marvelapi.data.di

import android.util.Log
import com.google.gson.GsonBuilder
import com.leonamleite.marvelapi.BuildConfig
import com.leonamleite.marvelapi.data.repositories.CharacterRepository
import com.leonamleite.marvelapi.data.repositories.CharacterRepositoryImp
import com.leonamleite.marvelapi.data.services.CharacterService
import com.leonamleite.marvelapi.networking.clients.GeneralApiClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModule {
    private const val OK_HTTP = "OkHttp"
    private const val BASE_URL = BuildConfig.BASE_URL

    fun load() {
        loadKoinModules(networkModules() + repositoriesModule())
    }

    private fun networkModules(): Module {
        return module {
            single {
                val interceptor = HttpLoggingInterceptor {
                    Log.e(this@DataModule.OK_HTTP, it)
                }
                interceptor.level = HttpLoggingInterceptor.Level.BODY

                GeneralApiClient(BASE_URL).generateClient()
            }

            single { GsonConverterFactory.create(GsonBuilder().create()) }

            single {
                createService<CharacterService>(get(), get())
            }
        }
    }

    private fun repositoriesModule(): Module {
        return module {
            single<CharacterRepository> { CharacterRepositoryImp(get()) }
        }
    }

    private inline fun <reified T> createService(
        client: OkHttpClient,
        factory: GsonConverterFactory
    ): T {
        return Retrofit.Builder()
            .baseUrl(this.BASE_URL)
            .client(client)
            .addConverterFactory(factory)
            .build().create(T::class.java)
    }
}