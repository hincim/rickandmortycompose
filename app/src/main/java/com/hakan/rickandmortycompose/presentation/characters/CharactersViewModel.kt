package com.hakan.rickandmortycompose.presentation.characters

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hakan.rickandmortycompose.domain.use_case.get_characters.GetCharactersUseCase
import com.hakan.rickandmortycompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {

    private val _state = mutableStateOf<CharacterState>(CharacterState())
    val state : State<CharacterState> = _state

    private var job: Job? = null

    init {
        getCharacters()
    }

    private fun getCharacters(){
        job?.cancel()
        job = getCharactersUseCase.executeGetCharacters().onEach {

            when(it){
                is Resource.Success ->{
                    _state.value = CharacterState(characters = it.data ?: emptyList())
                }
                is Resource.Loading ->{
                    _state.value = _state.value.copy(isLoading = true)
                }
                is Resource.Error ->{
                    _state.value = CharacterState(error = "Error")
                }
            }
        }.launchIn(viewModelScope)
    }
}








