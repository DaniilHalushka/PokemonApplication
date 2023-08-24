package com.example.pokemonapp.api

data class PokemonApiResult(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonNameAndURL>
)