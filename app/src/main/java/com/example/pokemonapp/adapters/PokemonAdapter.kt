package com.example.pokemonapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.Pokemon
import com.example.pokemonapp.R
import com.squareup.picasso.Picasso

class PokemonAdapter(private val pokemonList: List<Pokemon>) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pokemonImageView: ImageView = itemView.findViewById(R.id.pokemonImageView)
        val pokemonTextView: TextView = itemView.findViewById(R.id.pokemonTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.pokemon_list_item, parent, false)
        return PokemonViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.pokemonTextView.text = pokemon.name
        Picasso.get()
            .load(pokemon.imageURL)
            .into(holder.pokemonImageView)
        TODO("Not yet implemented")
    }
}