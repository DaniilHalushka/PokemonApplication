//package com.example.pokemonapp.database
//
//import androidx.lifecycle.LiveData
//import com.example.pokemonapp.models.Pokemon
//
//class PokemonRealization(private val pokemonDao: PokemonDao) : DataRepository {
//    override val allPokemons: LiveData<List<Pokemon>>
//        get() = pokemonDao.getAllPokemons()
//
//    override suspend fun insertPokemon(pokemon: PokemonEntity, onSuccess: () -> Unit) {
//        pokemonDao.insert(pokemon)
//        onSuccess()
//    }
//}