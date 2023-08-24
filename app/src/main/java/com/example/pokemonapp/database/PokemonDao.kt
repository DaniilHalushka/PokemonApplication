//package com.example.pokemonapp.database
//
//import androidx.lifecycle.LiveData
//import androidx.room.Dao
//import androidx.room.Delete
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import com.example.pokemonapp.models.Pokemon
//
//@Dao
//interface PokemonDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(pokemon:PokemonEntity)
//
//    @Query("SELECT * from pokemon_table")
//    fun getAllPokemons(): LiveData<List<Pokemon>>
//
//}