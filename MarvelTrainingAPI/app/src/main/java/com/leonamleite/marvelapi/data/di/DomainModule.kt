package com.leonamleite.marvelapi.data.di

import com.leonamleite.marvelapi.domain.ListCharacterUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {

    fun load() {
        loadKoinModules(characterModule())
    }

    private fun characterModule(): Module {
        return module {
            factory {
                ListCharacterUseCase(get())
            }
        }
    }
}