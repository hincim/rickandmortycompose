package com.hakan.rickandmortycompose.data.di

import com.hakan.rickandmortycompose.data.remote.dto.RandMAPI
import com.hakan.rickandmortycompose.data.repo.RandMRepositoryImpl
import com.hakan.rickandmortycompose.domain.repo.RandMRepository
import com.hakan.rickandmortycompose.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppApi() : RandMAPI{

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RandMAPI::class.java)

    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: RandMAPI): RandMRepository{

        return RandMRepositoryImpl(api)
    }
}













