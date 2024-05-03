package com.example.data.net.client

import com.example.data.net.entity.pokemon.InfoEntity
import com.example.data.net.entity.pokemondetails.PokemonEntity

interface BaseApiClient {
    suspend fun getPokemonList(): List<InfoEntity>
    suspend fun getPokemonPaged(offset: Int, limit: Int): List<InfoEntity>
    suspend fun getPokemonDetail(id: String): PokemonEntity
}