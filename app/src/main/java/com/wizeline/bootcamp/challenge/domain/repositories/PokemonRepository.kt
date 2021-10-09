package com.wizeline.bootcamp.challenge.domain.repositories

import com.wizeline.bootcamp.challenge.domain.usecases.UseCaseResult

interface PokemonRepository {
    fun getPokemon(pokemonId: String): UseCaseResult
}