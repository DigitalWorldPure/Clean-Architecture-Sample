package com.example.domain.di

import com.example.data.repository.PokemonsRemoteRepository
import com.example.domain.pagingsources.PokemonsPagingSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PokemonsPagingSourceModule {
    @Provides
    fun providePagingSource(repository: PokemonsRemoteRepository): PokemonsPagingSource = PokemonsPagingSource(repository)
}