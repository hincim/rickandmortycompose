package com.hakan.rickandmortycompose.domain.model

data class Episodes(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
)