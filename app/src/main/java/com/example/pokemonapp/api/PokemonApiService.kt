package com.example.pokemonapp.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService {
    @GET("pokemon")
    suspend fun getPokemonList() : PokemonListResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(
        @Path ("name") name:String
    ) : PokemonDetailsResponse
}