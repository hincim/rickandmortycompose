package com.hakan.rickandmortycompose.presentation.character_detail

import com.hakan.rickandmortycompose.domain.model.CharacterDetail


data class CharacterDetailState(
    val isLoading: Boolean = false,
    val character: CharacterDetail? = null,
    val error: String = "",
)
