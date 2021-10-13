package com.wizeline.bootcamp.challenge.data.services

import com.wizeline.bootcamp.challenge.data.mock.PokemonDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Path
import java.util.*

interface PokemonDetailsService {
    @GET("pokemon/{id}")
    fun getPokemon(@Path("id") pokemonId: Long?, @HeaderMap headers: Map<String, String> = Collections.emptyMap()): Call<PokemonDetails>
}