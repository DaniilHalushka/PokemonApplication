package com.example.pokemonapp.api

import com.example.pokemonapp.models.Type

class PokemonDetailsResponse(
    val id: Int,
    val name: String,
    val type: List<PokemonType>
)

class PokemonType(
    val number: Int,
    val type: Type
)