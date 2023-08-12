package com.hakan.rickandmortycompose.domain.use_case.get_characters

import com.hakan.rickandmortycompose.data.remote.dto.character_dto.toCharacterList
import com.hakan.rickandmortycompose.domain.model.Characters
import com.hakan.rickandmortycompose.domain.repo.RandMRepository
import com.hakan.rickandmortycompose.util.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOError
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repo: RandMRepository
) {

    fun executeGetCharacters(): kotlinx.coroutines.flow.Flow<Resource<List<Characters>>> = flow{

        try {
            emit(Resource.Loading())
            val characterList = repo.getCharacters()
            if (characterList.info.count != 0){
                emit(Resource.Success(characterList.toCharacterList()))
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