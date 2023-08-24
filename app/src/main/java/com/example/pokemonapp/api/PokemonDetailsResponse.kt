package com.example.pokemonapp.api

import com.example.pokemonapp.models.Type

data class PokemonDetailsResponse(
    val id: Int,
    val name: String,
    val types: List<PokemonType>
)

data class PokemonType(
    val number: Int,
    val type: Type
)