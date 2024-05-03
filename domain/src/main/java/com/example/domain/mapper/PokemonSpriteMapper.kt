package com.example.domain.mapper

import com.example.data.net.entity.pokemondetails.SpritesEntity
import com.example.domain.models.PokemonSprite

fun mapSprite(sprite: SpritesEntity): PokemonSprite = sprite.run {
    PokemonSprite(
        backDefault,
        backFemale,
        backShiny,
        backShinyFemale,
        frontDefault,
        frontFemale,
        frontShiny,
        frontShinyFemale
    )
}