package com.hakan.rickandmortycompose.domain.use_case.get_episodes

import com.hakan.rickandmortycompose.data.remote.dto.episodes.toEpisodesList
import com.hakan.rickandmortycompose.domain.model.Episodes
import com.hakan.rickandmortycompose.domain.repo.RandMRepository
import com.hakan.rickandmortycompose.util.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetEpisodesUseCase @Inject constructor(
    private val repo: RandMRepository
) {

    fun executeGetEpisodes(): kotlinx.coroutines.flow.Flow<Resource<List<Episodes>>> = flow{
        try {
            emit(Resource.Loading())
            val episodeList = repo.getEpisodes()
            if (episodeList.info.count != 0){
                emit(Resource.Success(episodeList.toEpisodesList()))
            }else{
                emit(Resource.Error("No movie found"))
            }
        }catch (e: IOError){
            emit(Resource.Error(message = "No internet connection"))
        }catch (e: HttpException){
            emit(Resource.Error(message = "Error"))
        }

    }

}