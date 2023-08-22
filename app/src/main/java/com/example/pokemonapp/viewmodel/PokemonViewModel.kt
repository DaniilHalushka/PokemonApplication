package com.example.pokemonapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.api.NetworkService.apiService
import com.example.pokemonapp.models.Pokemon
import com.example.pokemonapp.repository.PokemonRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {
    private val repository: PokemonRepository = PokemonRepository(apiService)
    private val pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData()

    val pokemonLiveData: LiveData<List<Pokemon>> get() = pokemons
    init {
        loadPokemonList()
    }

    private fun loadPokemonList() {
        viewModelScope.launch {
            val response = repository.getPokemonList()

            if (response != null) {
                val updatedList = mutableListOf<Pokemon>()

                val deferredList = response.results.map { pokemon ->
                    async {
                        val numberToURL = pokemon.url
                            .replace("https://pokeapi.co/api/v2/pokemon/", "")
                            .replace("/", "").toInt()

                        repository.getPokemonDetails(numberToURL)
                    }
                }

                for (deferredDetailsResponse in deferredList) {
                    val detailsResponse = deferredDetailsResponse.await()

                    if (detailsResponse != null) {
                        updatedList.add(
                            Pokemon(
                                detailsResponse.id,
                                detailsResponse.name,
                                detailsResponse.type.map { type ->
                                    type.type
                                }
                            )
                        )
                    }
                }

                // Now you can notify your UI or do something with the updatedList
            }
        }
    }

//    private fun loadPokemonList() {
//        viewModelScope.launch {
//            val response = repository.getPokemonList()
//
//            if (response != null) {
//                val updatedList = mutableListOf<Pokemon>()
//                val pokemonList = response.results
//                for (pokemon in pokemonList) {
//                    val numberToURL = pokemon.url
//                        .replace("https://pokeapi.co/api/v2/pokemon/", "")
//                        .replace("/", "").toInt()
//
//                    val detailsResponse = repository.getPokemonDetails(numberToURL)
//
//                    if (detailsResponse != null) {
//                        updatedList.add(
//                            Pokemon(
//                                detailsResponse.id,
//                                detailsResponse.name,
//                                detailsResponse.type.map { type ->
//                                    type.type
//                                }
//                            )
//                        )
//                    }
//                }
//                pokemons.postValue(updatedList)
//            }
//        }
//    }
}