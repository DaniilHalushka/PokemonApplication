package com.example.pokemonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.adapters.PokemonAdapter
import com.example.pokemonapp.viewmodel.PokemonViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: PokemonViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokemon_list_layout)

        val pokemonRecyclerView: RecyclerView = findViewById(R.id.pokemonRecyclerView)
        val adapter = PokemonAdapter(mutableListOf())

        pokemonRecyclerView.layoutManager = LinearLayoutManager(this)

        pokemonRecyclerView.adapter = adapter

        viewModel.pokemonListLiveData.observe(this, Observer{pokemonList ->
            adapter.updateData(pokemonList)
            viewModel.loadPokemonList()
        })
    }
}