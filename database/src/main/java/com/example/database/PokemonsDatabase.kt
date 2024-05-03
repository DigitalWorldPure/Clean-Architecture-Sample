package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.dao.PokemonDao
import dimaarts.ru.data.repository.database.Pokemon

@Database(entities = [Pokemon::class], version = 2)
abstract class PokemonsDatabase: RoomDatabase() {
    abstract fun getPokemonsDao(): PokemonDao
}