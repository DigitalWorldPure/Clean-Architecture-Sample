package com.example.data.net.entity.pokemondetails

data class PokemonEntity (
    val id: Long,
    val name: String? = null,
    val height: Int? = null,
    val sprites: SpritesEntity? = null,
    var detailLoaded: Boolean = false,
    var loadingError: String? = null
)