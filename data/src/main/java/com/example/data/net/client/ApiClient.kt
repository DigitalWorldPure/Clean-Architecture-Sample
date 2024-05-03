package com.example.data.net.client

import com.example.data.net.entity.pokemondetails.PokemonEntity
import com.example.data.net.PokeApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import com.example.data.net.entity.pokemon.InfoEntity
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient(url: String, client: OkHttpClient) : BaseApiClient {

    private var retrofitClient: PokeApi = Retrofit.Builder()
        .baseUrl(url)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build().create(PokeApi::class.java)

    override suspend fun getPokemonList(): List<InfoEntity> {
        return retrofitClient.getPokemonPaged(0, 9999).results
    }

    override suspend fun getPokemonPaged(offset: Int, limit: Int): List<InfoEntity> {
        return retrofitClient.getPokemonPaged(offset, limit).results
    }

    override suspend fun getPokemonDetail(id: String): PokemonEntity {
        return retrofitClient.getPokemonDetail(id)
    }
}