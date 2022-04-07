package com.leonamleite.marvelapi.data.repositories

import com.leonamleite.marvelapi.model.BaseResult
import com.leonamleite.marvelapi.model.Character
import kotlinx.coroutines.flow.Flow


interface CharacterRepository {
    suspend fun listCharacteres(limit: Int): Flow<BaseResult<Character>>
}