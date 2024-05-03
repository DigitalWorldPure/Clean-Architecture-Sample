package com.example.domain.mapper

import com.example.data.net.entity.pokemondetails.PokemonEntity
import com.example.domain.models.PokemonDetails

fun mapDetailData(source: PokemonEntity): PokemonDetails = source.run {
    PokemonDetails(
        id,
        name,
        height,
        sprites?.let(::mapSprite),
        detailLoaded,
        loadingError
    )
}