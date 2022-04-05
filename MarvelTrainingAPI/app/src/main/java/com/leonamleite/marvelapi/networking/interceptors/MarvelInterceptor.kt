package com.leonamleite.marvelapi.networking.interceptors

import com.leonamleite.marvelapi.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.math.BigInteger
import java.security.MessageDigest
import java.util.*

class MarvelInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        generateTimeStamp()

        val original = chain.request()
        val requestBuilder = original.newBuilder()
        requestBuilder.addHeader(TIME_STAMP, timeStamp)
        requestBuilder.addHeader(API_KEY, BuildConfig.PUBLIC_KEY)
        requestBuilder.addHeader(HASH, generateHash())

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
    companion object {
        private const val API_KEY = "apikey"
        private const val TIME_STAMP = "ts"
        private const val HASH = "hash"

        private lateinit var timeStamp : String

        private fun generateTimeStamp(){
            timeStamp = Date().time.toString()
        }

        private fun generateHash() : String {
            val md = MessageDigest.getInstance("MD5")
            val concatKeys = timeStamp + BuildConfig.PRIVATE_KEY + BuildConfig.PUBLIC_KEY
            return BigInteger(1, md.digest(concatKeys.toByteArray())).toString(16).padStart(32, '0')
        }
    }
//  fetch(`http://gateway.marvel.com/v1/public/comics/428?ts=${timeStamp}&apikey=ad02f2182a7a14379d1aaa39f7f5f216&hash=${md5}&limit=9&offset=3`)
//apiKey
    //privateKey
    //hasMap
    //timestamp


    /*
    * normal
    * carro (modelo, ano, portas, marchas,tetosSolares)
    * carro (modelo, ano, portas, marchas)
    * carro (modelo, ano, marchas)
    *
    * builder
    * carro() privados [modelo, ano, portas, marchas,tetosSolares]
    * getInstance() -> carro(params...)
    * carro()
    * .builder()
    * .modelo("normal")
    * .ano(2022)
    * .portas(4)
    * .marchas(5)
    * .tetosSolares(1)
    *
    *
    *
    * carro()
    * .builder()
    * .modelo("normal")
    * .ano(2022)
    * .portas(4)
    * .marchas(5)
    *
    *
    * * carro()
    * .builder()
    * .modelo("normal")
    * .ano(2022)
    * .marchas(5)
    *
    *
    *
    * * carro()
    * .builder()
    * .modelo("normal")
    * */

}