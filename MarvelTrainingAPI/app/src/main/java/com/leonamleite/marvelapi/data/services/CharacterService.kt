package com.leonamleite.marvelapi.data.services

import com.leonamleite.marvelapi.model.BaseData
import com.leonamleite.marvelapi.model.Character
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {

    @GET("/v1/public/characters/")
    suspend fun listCharacteres(@Path("limit") limit: String) : BaseData<Character>
}