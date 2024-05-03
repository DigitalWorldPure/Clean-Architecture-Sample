package com.example.domain.usecases

import com.example.domain.models.PokemonDetails
import com.example.domain.models.PokemonSearchQuery
import com.example.domain.models.PokemonSearchResult
import com.example.domain.pagingsources.PokemonsPagingSource

interface PokemonUseCase: UseCase {
    fun getListDataSource(): PokemonsPagingSource
    suspend fun searchPokemon(query: PokemonSearchQuery): PokemonSearchResult
    suspend fun getDetail(id: String): PokemonDetails
}