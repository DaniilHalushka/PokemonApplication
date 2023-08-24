package com.example.pokemonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.adapters.PokemonAdapter
import com.example.pokemonapp.models.Pokemon
import com.example.pokemonapp.viewmodel.PokemonViewModel
import com.example.pokemonapp.viewmodel.PokemonViewModelFactory

class MainActivity : ComponentActivity() {

    private val pokemonViewModel by lazy{
        ViewModelProvider(this, PokemonViewModelFactory())
            .get(PokemonViewModel::class.java)
    }

    private val pokemonRecyclerView by lazy {
        findViewById<RecyclerView>(R.id.pokemonRecyclerView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokemon_list_layout)

        pokemonViewModel.pokemons.observe(this, Observer {
            loadRecyclerView(it)
        })
    }

    private fun loadRecyclerView(pokemons: List<Pokemon?>) {
            pokemonRecyclerView.layoutManager = LinearLayoutManager(this)
            pokemonRecyclerView.adapter = PokemonAdapter(pokemons)
    }
}