package com.hakan.rickandmortycompose.data.repo

import com.hakan.rickandmortycompose.data.remote.dto.RandMAPI
import com.hakan.rickandmortycompose.data.remote.dto.character_detail_dto.CharacterDetailDto
import com.hakan.rickandmortycompose.data.remote.dto.character_dto.CharactersDto
import com.hakan.rickandmortycompose.data.remote.dto.episodes.EpisodesDto
import com.hakan.rickandmortycompose.domain.repo.RandMRepository
import javax.inject.Inject

class RandMRepositoryImpl @Inject constructor(
    private val api : RandMAPI
) : RandMRepository {
    override suspend fun getCharacters(): CharactersDto {
       return api.getCharacters()
    }

    override suspend fun getCharacterDetail(id: String): CharacterDetailDto {
        return api.getCharacterDetail(id)
    }

    override suspend fun getEpisodes(): EpisodesDto {
        return api.getEpisodes()
    }
}