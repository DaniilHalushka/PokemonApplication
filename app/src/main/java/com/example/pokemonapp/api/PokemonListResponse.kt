package com.example.pokemonapp.api

data class PokemonListResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonApiResponse>
)
