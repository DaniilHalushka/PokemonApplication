package com.example.pokemonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.adapters.PokemonAdapter
import com.example.pokemonapp.ui.theme.PokemonAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pokemon_list_layout)

        val pokemonRecyclerView: RecyclerView = findViewById(R.id.pokemonRecyclerView)

        val pokemonList: List<Pokemon> = mutableListOf()
        val adapter = PokemonAdapter(pokemonList)
        pokemonRecyclerView.adapter = adapter
    }
}