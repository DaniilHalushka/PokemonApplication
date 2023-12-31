package com.example.pokemonapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.R
import com.example.pokemonapp.models.Pokemon
import com.squareup.picasso.Picasso

class PokemonAdapter(private val pokemonList: List<Pokemon?>) :
    RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

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
        holder.showInfo(pokemon)
    }


    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun showInfo(item: Pokemon?) = with(itemView) {
            val pokemonImage: ImageView = itemView.findViewById(R.id.pokemonImage)
            val pokemonName: TextView = itemView.findViewById(R.id.pokemonName)


            item?.let {
                Picasso.get()
                    .load(it.imageURL)
                    .into(pokemonImage)

                pokemonName.text = item.capitalizeName
            }
        }
    }
}