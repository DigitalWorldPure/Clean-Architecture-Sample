package com.example.data.net

import com.example.data.net.POKEMON_API_VERSION
import com.example.data.net.entity.pokemon.PokemonListEntity
import com.example.data.net.entity.pokemondetails.PokemonEntity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {
    @GET("$POKEMON_API_VERSION/pokemon")
    suspend fun getPokemonPaged(@Query("offset") offset: Int, @Query("limit") limit: Int = 20): PokemonListEntity
    @GET("$POKEMON_API_VERSION/pokemon/{id}")
    suspend fun getPokemonDetail(@Path("id") id: String): PokemonEntity
}