package com.example.data.di

import com.example.data.net.client.ApiClient
import com.example.data.repository.PokemonsLocalRepository
import com.example.data.repository.PokemonsRemoteRepository
import com.example.database.dao.PokemonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun provideRemoteRepository(apiClient: ApiClient) = PokemonsRemoteRepository(apiClient)

    @Provides
    fun provideLocalRepository(pokemonsDao: PokemonDao) = PokemonsLocalRepository(pokemonsDao)
}