package com.example.data.net.entity.pokemon

data class PokemonListEntity(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<InfoEntity>
)