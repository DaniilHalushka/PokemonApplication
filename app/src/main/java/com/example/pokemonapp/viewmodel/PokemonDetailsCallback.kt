package com.example.pokemonapp.viewmodel

import com.example.pokemonapp.models.Pokemon

interface PokemonDetailsCallback {
    fun onPokemonDetailsLoaded(details: MutableList<Pokemon>)
}