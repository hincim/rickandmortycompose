package com.hakan.rickandmortycompose.presentation.episodes

import com.hakan.rickandmortycompose.domain.model.Episodes

data class EpisodeState(
    val isLoading: Boolean = false,
    val episodes: List<Episodes> = emptyList(),
    val error: String = "",
)