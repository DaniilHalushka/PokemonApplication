package com.example.pokemonapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.api.NetworkService.apiService
import com.example.pokemonapp.api.PokemonApiResponse
import com.example.pokemonapp.api.PokemonDetailsResponse
import com.example.pokemonapp.models.Pokemon
import com.example.pokemonapp.repository.PokemonRepository
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {
    private val repository: PokemonRepository = PokemonRepository(apiService)

    private val pokemonMutableListLiveData: MutableLiveData<List<PokemonApiResponse>> =
        MutableLiveData()
    val pokemonListLiveData: LiveData<List<PokemonApiResponse>> = pokemonMutableListLiveData

    fun loadPokemonList() {
        viewModelScope.launch {
            val response = repository.getPokemonList()
            pokemonMutableListLiveData.value = response

            val updatedList = response.map{pokemonApiResponse ->
                val detailsResponse = repository.getPokemonDetails(pokemonApiResponse.name)

                PokemonApiResponse(
                    name = pokemonApiResponse.name,
                    url = pokemonApiResponse.url,
                    details = detailsResponse
                )
            }
            pokemonMutableListLiveData.value = updatedList
        }
    }
    suspend fun getPokemonDetails(name: String): PokemonDetailsResponse {
        return apiService.getPokemonDetails(name)
    }
}