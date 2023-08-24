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
    //    private val repository: PokemonRepository = PokemonRepository(apiService)
    var pokemons = MutableLiveData<List<Pokemon?>>()

    //val pokemonLiveData: LiveData<List<Pokemon>> get() = pokemons

    init {
        Thread(Runnable {
            loadPokemonList()
        }).start()
    }

    private fun loadPokemonList() {
        val pokemonApi = PokemonRepository().getPokemonList()

        pokemonApi?.results?.let {
            pokemons.postValue( it.map { pokemon ->
                val utilNumber = pokemon.url
                    .replace("https://pokeapi.co/api/v2/pokemon/", "")
                    .replace("/", "").toInt()

                val pokemonDetailsResponse = PokemonRepository().getPokemonDetails(utilNumber)

                pokemonDetailsResponse?.let {
                    Pokemon(
                        pokemonDetailsResponse.id,
                        pokemonDetailsResponse.name,
                        pokemonDetailsResponse.types.map { type ->
                            type.type
                        }
                    )
                }
            }
            )
        }
    }
}