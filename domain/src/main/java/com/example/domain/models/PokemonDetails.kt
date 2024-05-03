package com.example.domain.models

data class PokemonDetails (
    val id: Long,
    val name: String? = null,
    val height: Int? = null,
    val sprites: PokemonSprite? = null,
    var detailLoaded: Boolean = false,
    var loadingError: String? = null
)