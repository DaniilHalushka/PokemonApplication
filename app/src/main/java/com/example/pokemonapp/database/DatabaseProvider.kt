//package com.example.pokemonapp.database
//
//import android.content.Context
//import androidx.room.Room
//
//object DatabaseProvider {
//    private var database: PokemonDatabase? = null
//
//    @Synchronized
//    fun getInstance(context: Context): PokemonDatabase {
//        return if (database == null){
//            database = Room.databaseBuilder(
//                context,
//                PokemonDatabase:: class.java,
//                "pokemon_database").build()
//            database as PokemonDatabase
//        } else {
//            database as PokemonDatabase
//        }
//    }
//}