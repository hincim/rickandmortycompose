package com.hakan.rickandmortycompose.data.remote.dto

import com.hakan.rickandmortycompose.data.remote.dto.character_detail_dto.CharacterDetailDto
import com.hakan.rickandmortycompose.data.remote.dto.character_dto.CharactersDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyAPI {

    @GET("character")
    suspend fun getCharacters(): CharactersDto

    @GET("character/{id}")
    suspend fun getCharacterDetail(@Path("id") id: Int): CharacterDetailDto

}