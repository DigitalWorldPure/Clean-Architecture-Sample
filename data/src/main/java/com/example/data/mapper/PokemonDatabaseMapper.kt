package com.example.data.mapper

import com.example.data.net.entity.pokemondetails.PokemonEntity
import com.example.data.net.entity.pokemondetails.SpritesEntity
import dimaarts.ru.data.repository.database.Pokemon

object PokemonDatabaseMapper {
    fun mapFrom(p: Pokemon): PokemonEntity {
        return PokemonEntity(p.id, p.name, p.height, SpritesEntity(p.backDefault, p.backFemale, p.backShiny, p.backShinyFemale, p.frontDefault, p.frontFemale, p.frontShiny, p.frontShinyFemale), p.haveDetailInfo, p.loadingError)
    }

    fun map(pe: PokemonEntity): Pokemon {
        return Pokemon(pe.id, pe.name, pe.height, pe.sprites?.backDefault, pe.sprites?.backFemale, pe.sprites?.backShiny, pe.sprites?.backShinyFemale, pe.sprites?.frontDefault, pe.sprites?.frontFemale, pe.sprites?.frontShiny, pe.sprites?.frontShinyFemale, pe.loadingError, pe.detailLoaded)
    }

    fun mapFrom(pl: List<Pokemon>): List<PokemonEntity> {
        val result = arrayListOf<PokemonEntity>()
        pl.forEach {
            result.add(mapFrom(it))
        }
        return result
    }

    fun map(pel: List<PokemonEntity>): List<Pokemon> {
        val result = arrayListOf<Pokemon>()
        pel.forEach {
            result.add(map(it))
        }
        return result
    }
}