package com.hakan.rickandmortycompose.domain.model

import com.hakan.rickandmortycompose.data.remote.dto.character_detail_dto.Origin

data class CharacterDetail(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val image: String,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
)
