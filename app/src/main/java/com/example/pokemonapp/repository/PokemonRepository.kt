package com.example.pokemonapp.repository

import android.util.Log
import com.example.pokemonapp.api.NetworkService
import com.example.pokemonapp.api.PokemonApiResult
import com.example.pokemonapp.api.PokemonDetailsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepository {
    fun getPokemonList() : PokemonApiResult? {
        val getResult = NetworkService.apiService.getPokemonList()
        return getResult.execute().body()
    }

    fun getPokemonDetails(numbers: Int): PokemonDetailsResponse?{
        val getResult = NetworkService.apiService.getPokemonDetails(numbers)
        return getResult.execute().body()
    }
}

