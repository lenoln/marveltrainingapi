package com.leonamleite.marvelapi.data.repositories

import com.leonamleite.marvelapi.data.services.CharacterService
import com.leonamleite.marvelapi.model.BaseResult
import com.leonamleite.marvelapi.model.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class CharacterRepositoryImp(
    private val service: CharacterService
) : CharacterRepository {
    override suspend fun listCharacteres(limit: Int): Flow<BaseResult<Character>> = flow {
        try {
            val characterList = service.listCharacteres(limit)
            emit(characterList)
        } catch (ex: HttpException) {
            throw ex
        }
    }
}