package com.hakan.rickandmortycompose.presentation.episodes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hakan.rickandmortycompose.domain.use_case.get_episodes.GetEpisodesUseCase
import com.hakan.rickandmortycompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(
private val getEpisodesUseCase: GetEpisodesUseCase
): ViewModel() {

    private val _state = mutableStateOf<EpisodeState>(EpisodeState())
    val state : State<EpisodeState> = _state

    private var job: Job? = null

    init {
        getEpisodes()
    }

    private fun getEpisodes(){
        job?.cancel()
        job = getEpisodesUseCase.executeGetEpisodes().onEach {

            when(it){
                is Resource.Success ->{
                    _state.value = EpisodeState(episodes = it.data ?: emptyList())
                }
                is Resource.Loading ->{
                    _state.value = _state.value.copy(isLoading = true)
                }
                is Resource.Error ->{
                    _state.value = EpisodeState(error = "Error")
                }
            }
        }.launchIn(viewModelScope)
    }
}