package com.example.data.repository

import com.example.data.net.client.BaseApiClient
import com.example.data.net.entity.pokemon.InfoEntity
import com.example.data.net.entity.pokemondetails.PokemonEntity

class PokemonsRemoteRepository(private val apiClient: BaseApiClient) {
    suspend fun getPokemonList(): List<InfoEntity> = apiClient.getPokemonList()
    suspend fun getPokemonPaged(offset: Int, limit: Int): List<InfoEntity> = apiClient.getPokemonPaged(offset, limit)
    suspend fun getPokemonDetail(id: String): PokemonEntity = apiClient.getPokemonDetail(id)
}