package com.example.domain.interactors

import com.example.data.repository.PokemonsRemoteRepository
import com.example.domain.mapper.mapDetailData
import com.example.domain.models.PokemonDetails
import com.example.domain.models.PokemonSearchQuery
import com.example.domain.models.PokemonSearchResult
import com.example.domain.pagingsources.PokemonsPagingSource
import com.example.domain.usecases.PokemonUseCase
import javax.inject.Inject

class PokemonInteractor(private val dataSource: PokemonsPagingSource, private val repository: PokemonsRemoteRepository): PokemonUseCase {

    override fun getListDataSource(): PokemonsPagingSource = dataSource

    override suspend fun searchPokemon(query: PokemonSearchQuery): PokemonSearchResult {
        TODO("Not yet implemented")
    }

    override suspend fun getDetail(id: String): PokemonDetails = repository.getPokemonDetail(id).let(::mapDetailData)
}