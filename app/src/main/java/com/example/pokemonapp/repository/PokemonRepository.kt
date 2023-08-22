package com.example.pokemonapp.repository

import com.example.pokemonapp.api.PokemonApiService
import com.example.pokemonapp.api.PokemonDetailsResponse
import com.example.pokemonapp.api.PokemonListResponse

class PokemonRepository(private val apiService: PokemonApiService) {
    fun getPokemonList(limit: Int = 151): PokemonListResponse? {
        val getResult = apiService.getPokemonList(limit)
        return getResult.execute().body()
    }

    fun getPokemonDetails(numbers: Int): PokemonDetailsResponse?{
        val getResult = apiService.getPokemonDetails(numbers)
        return getResult.execute().body()
    }
}