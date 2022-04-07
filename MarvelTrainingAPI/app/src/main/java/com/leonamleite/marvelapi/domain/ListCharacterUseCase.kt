package com.leonamleite.marvelapi.domain

import com.leonamleite.marvelapi.core.UseCase
import com.leonamleite.marvelapi.data.repositories.CharacterRepository
import com.leonamleite.marvelapi.model.BaseResult
import com.leonamleite.marvelapi.model.Character
import kotlinx.coroutines.flow.Flow

class ListCharacterUseCase(
    private val repository: CharacterRepository
) : UseCase<Int, BaseResult<Character>>() {
    override suspend fun execute(param: Int): Flow<BaseResult<Character>> {
        return repository.listCharacteres(param)
    }
}