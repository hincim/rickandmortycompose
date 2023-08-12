package com.hakan.rickandmortycompose.presentation.characters

import com.hakan.rickandmortycompose.domain.model.Characters

data class CharacterState(
    val isLoading: Boolean = false,
    val characters: List<Characters> = emptyList(),
    val error: String = "",
)