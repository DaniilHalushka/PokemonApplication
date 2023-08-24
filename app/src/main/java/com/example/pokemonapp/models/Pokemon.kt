package com.example.pokemonapp.models

data class Pokemon(
    val number: Int,
    val name: String,
    val type: List<Type>
) {
    val capitalizeName = name.capitalize()
    private val numberToURL = number.toString().padStart(3,'0')
    val imageURL = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/$numberToURL.png"
}