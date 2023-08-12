package com.hakan.rickandmortycompose.data.remote.dto.character_detail_dto

import com.hakan.rickandmortycompose.domain.model.CharacterDetail

data class CharacterDetailDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)
fun CharacterDetailDto.toCharacterDetail() : CharacterDetail {
    return CharacterDetail(name,episode,gender,image,status,origin,species,status)
}