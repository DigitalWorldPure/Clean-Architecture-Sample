package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dimaarts.ru.data.repository.database.Pokemon

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon")
    suspend fun all(): List<Pokemon>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<Pokemon>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(element: Pokemon)

    @Query("SELECT * FROM pokemon where name like :query order by name desc")
    suspend fun searchPokemon(query: String): List<Pokemon>

    @Query("SELECT * FROM pokemon where id=:id")
    suspend fun getPokemon(id: Int): Pokemon
}