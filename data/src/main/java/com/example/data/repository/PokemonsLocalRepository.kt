package com.example.data.repository

import com.example.data.mapper.PokemonDatabaseMapper
import com.example.data.net.entity.pokemondetails.PokemonEntity
import com.example.database.dao.PokemonDao

class PokemonsLocalRepository(private val pokemonsDao: PokemonDao) {
    suspend fun insert(element: PokemonEntity) {
        pokemonsDao.insert(element.let(PokemonDatabaseMapper::map))
    }

    suspend fun insertAll(list: List<PokemonEntity>) {
        pokemonsDao.insertAll(list.map(PokemonDatabaseMapper::map))
    }

    suspend fun searchPokemon(query: String): List<PokemonEntity> {
        return pokemonsDao.searchPokemon("%$query%").map (PokemonDatabaseMapper::mapFrom)
    }

    suspend fun getPokemon(id: Int): PokemonEntity {
        return pokemonsDao.getPokemon(id).let(PokemonDatabaseMapper::mapFrom)
    }

    suspend fun all(): List<PokemonEntity> {
        return pokemonsDao.all().map (PokemonDatabaseMapper::mapFrom)
    }
}