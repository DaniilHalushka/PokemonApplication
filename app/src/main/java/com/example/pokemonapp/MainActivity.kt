package com.example.pokemonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.adapters.PokemonAdapter
import com.example.pokemonapp.models.Pokemon
import com.example.pokemonapp.viewmodel.PokemonViewModel
import com.example.pokemonapp.viewmodel.PokemonViewModelFactory

class MainActivity : ComponentActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this, PokemonViewModelFactory())[PokemonViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokemon_list_layout)

        viewModel.pokemonLiveData.observe(this, Observer { pokemonList ->
            startRecyclerView(it)
        })
    }

    private fun startRecyclerView(existingPokemons: MutableList<Pokemon?>){
        val pokemonRecyclerView: RecyclerView = findViewById(R.id.pokemonRecyclerView)
        val adapter = PokemonAdapter(existingPokemons)

        pokemonRecyclerView.layoutManager = LinearLayoutManager(this)

        pokemonRecyclerView.adapter = adapter
    }
}