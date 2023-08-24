//package com.example.pokemonapp.database
//
//import androidx.lifecycle.LiveData
//import com.example.pokemonapp.models.Pokemon
//
//interface DataRepository {
//    val allPokemons : LiveData<List<Pokemon>>
//
//    suspend fun insertPokemon(pokemon: PokemonEntity, onSuccess: () -> Unit)
//}