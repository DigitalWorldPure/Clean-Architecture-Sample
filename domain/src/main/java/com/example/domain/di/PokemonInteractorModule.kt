package com.example.domain.di

import com.example.data.repository.PokemonsRemoteRepository
import com.example.domain.interactors.PokemonInteractor
import com.example.domain.pagingsources.PokemonsPagingSource
import com.example.domain.usecases.PokemonUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PokemonUseCaseModule {
    @Provides
    fun provideUseCase(dataSource: PokemonsPagingSource, remoteRepository: PokemonsRemoteRepository): PokemonUseCase = PokemonInteractor(dataSource, remoteRepository)
}