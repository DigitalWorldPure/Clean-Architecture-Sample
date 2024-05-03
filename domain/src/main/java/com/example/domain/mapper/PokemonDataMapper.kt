package com.example.domain.mapper

import com.example.data.net.entity.pokemon.InfoEntity
import com.example.domain.models.PokemonShortData

fun mapData(source: InfoEntity): PokemonShortData = PokemonShortData(source.name, source.url)
