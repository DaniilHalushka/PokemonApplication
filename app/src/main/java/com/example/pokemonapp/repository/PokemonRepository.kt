package com.example.pokemonapp.repository

import com.example.pokemonapp.api.PokemonApiResponse
import com.example.pokemonapp.api.PokemonApiService
import com.example.pokemonapp.api.PokemonDetailsResponse
import com.example.pokemonapp.api.PokemonListResponse

class PokemonRepository(private val apiService: PokemonApiService) {
    suspend fun getPokemonList(): List<PokemonApiResponse>{
        val response : PokemonListResponse = apiService.getPokemonList()
        return response.results
    }

    suspend fun getPokemonDetails(name: String): PokemonDetailsResponse{
        return apiService.getPokemonDetails(name)
    }
}