package com.hakan.rickandmortycompose.domain.repo

import com.hakan.rickandmortycompose.data.remote.dto.character_detail_dto.CharacterDetailDto
import com.hakan.rickandmortycompose.data.remote.dto.character_dto.CharactersDto

interface RandMRepository {

    suspend fun getCharacters() : CharactersDto
    suspend fun getCharacterDetail(id: String) : CharacterDetailDto
}