package com.leonamleite.marvelapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leonamleite.marvelapi.domain.ListCharacterUseCase
import com.leonamleite.marvelapi.model.BaseResult
import com.leonamleite.marvelapi.model.Character
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainViewModel(
    private val listCharacterUseCase: ListCharacterUseCase
) : ViewModel() {

    private val _characteres = MutableLiveData<State>()
    val characteres: LiveData<State> = _characteres

    fun getCharacterList(limit: Int) {
        viewModelScope.launch {
            listCharacterUseCase(limit)
                .onStart {
                    _characteres.postValue(State.Loading)
                }
                .catch {
                    _characteres.postValue(State.Error(it))
                }
                .collect {
                    _characteres.postValue(State.Success(it))
                }
        }
    }

    sealed class State {
        object Loading : State()
        data class Success(val list: BaseResult<Character>) : State()
        data class Error(val error: Throwable) : State()
    }
}