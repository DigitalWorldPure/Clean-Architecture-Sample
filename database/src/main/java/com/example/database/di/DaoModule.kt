package com.example.database.di

import com.example.database.PokemonsDatabase
import com.example.database.dao.PokemonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DaoModule {
    @Provides
    fun providesTopicsDao(
        database: PokemonsDatabase,
    ): PokemonDao = database.getPokemonsDao()
}