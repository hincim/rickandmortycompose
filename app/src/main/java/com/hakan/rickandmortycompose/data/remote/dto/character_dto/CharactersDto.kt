package com.hakan.rickandmortycompose.data.remote.dto.character_dto

import com.hakan.rickandmortycompose.domain.model.Characters

data class CharactersDto(
    val info: İnfo,
    val results: List<Result>
)

fun CharactersDto.toCharacterList() :List<Characters> {
    return results.map{ res -> Characters(res.id,res.image,res.name,res.status)}
}
