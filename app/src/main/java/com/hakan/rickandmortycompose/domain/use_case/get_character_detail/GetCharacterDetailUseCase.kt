package com.hakan.rickandmortycompose.domain.use_case.get_character_detail

import com.hakan.rickandmortycompose.data.remote.dto.character_detail_dto.toCharacterDetail
import com.hakan.rickandmortycompose.domain.model.CharacterDetail
import com.hakan.rickandmortycompose.domain.repo.RandMRepository
import com.hakan.rickandmortycompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetCharacterDetailUseCase @Inject constructor(
    private val repo: RandMRepository
) {
    fun executeGetCharacterDetails(imdbId: String) : Flow<Resource<CharacterDetail>> = flow {
        try {
            emit(Resource.Loading())
            val characterDetail = repo.getCharacterDetail(imdbId)
            emit(Resource.Success(characterDetail.toCharacterDetail()))
        }catch (e: IOError){
            emit(Resource.Error(message = "No internet connection"))
        }catch (e: HttpException){
            emit(Resource.Error(message = "Error"))
        }
    }
}