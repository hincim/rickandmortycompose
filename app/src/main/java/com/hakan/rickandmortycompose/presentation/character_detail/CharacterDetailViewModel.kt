package com.hakan.rickandmortycompose.presentation.character_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hakan.rickandmortycompose.domain.use_case.get_character_detail.GetCharacterDetailUseCase
import com.hakan.rickandmortycompose.util.Constants.character_id
import com.hakan.rickandmortycompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase,
    private val stateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf<CharacterDetailState>(CharacterDetailState())
    val state : State<CharacterDetailState> = _state

    init {
        stateHandle.get<String>(character_id)?.let {
            getCharacterDetail(it)
        }
    }

    private var job: Job? = null

    private fun getCharacterDetail(imdbId: String){
        job?.cancel()
        job = getCharacterDetailUseCase.executeGetCharacterDetails(imdbId).onEach {

            when(it){
                is Resource.Success ->{
                    _state.value = CharacterDetailState(character = it.data)
                }
                is Resource.Loading ->{
                    _state.value = _state.value.copy(isLoading = true)
                }
                is Resource.Error ->{
                    _state.value = CharacterDetailState(error = "Error")
                }
            }
        }.launchIn(viewModelScope)
    }
}