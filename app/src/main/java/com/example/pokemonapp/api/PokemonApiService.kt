package com.example.pokemonapp.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {
    @GET("pokemon")
    fun getPokemonList(
    ): Call<PokemonApiResult>

    @GET("pokemon/{number}")
    fun getPokemonDetails(
        @Path("number") number: Int
    ): Call<PokemonDetailsResponse>
}