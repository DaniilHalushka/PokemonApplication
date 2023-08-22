package com.example.pokemonapp.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {
    @GET("pokemon")
    fun getPokemonList(
        @Query("limit") limit: Int
    ): Call<PokemonListResponse>

    @GET("pokemon/{count}")
    fun getPokemonDetails(
        @Path("count") count: Int
    ): Call<PokemonDetailsResponse>
}