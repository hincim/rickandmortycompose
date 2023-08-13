package com.hakan.rickandmortycompose.data.remote.dto

import com.hakan.rickandmortycompose.data.remote.dto.character_detail_dto.CharacterDetailDto
import com.hakan.rickandmortycompose.data.remote.dto.character_dto.CharactersDto
import com.hakan.rickandmortycompose.data.remote.dto.episodes.EpisodesDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RandMAPI {

    @GET("character")
    suspend fun getCharacters(): CharactersDto

    @GET("character/{id}")
    suspend fun getCharacterDetail(@Path("id") id: String): CharacterDetailDto

    @GET("episode")
    suspend fun getEpisodes(): EpisodesDto

}