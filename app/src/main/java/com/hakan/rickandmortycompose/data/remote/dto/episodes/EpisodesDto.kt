package com.hakan.rickandmortycompose.data.remote.dto.episodes

import com.hakan.rickandmortycompose.domain.model.Episodes

data class EpisodesDto(
    val info: İnfo,
    val results: List<Result>
)

fun EpisodesDto.toEpisodesList() :List<Episodes> {
    return results.map{ res -> Episodes(res.air_date,res.characters,res.episode,res.created,res.id,res.name) }
}