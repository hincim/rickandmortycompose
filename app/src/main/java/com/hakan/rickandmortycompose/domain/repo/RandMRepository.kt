package com.hakan.rickandmortycompose.domain.repo

import com.hakan.rickandmortycompose.data.remote.dto.character_detail_dto.CharacterDetailDto
import com.hakan.rickandmortycompose.data.remote.dto.character_dto.CharactersDto
import com.hakan.rickandmortycompose.data.remote.dto.episodes.EpisodesDto

interface RandMRepository {

    suspend fun getCharacters() : CharactersDto
    suspend fun getCharacterDetail(id: String) : CharacterDetailDto
    suspend fun getEpisodes() : EpisodesDto
}