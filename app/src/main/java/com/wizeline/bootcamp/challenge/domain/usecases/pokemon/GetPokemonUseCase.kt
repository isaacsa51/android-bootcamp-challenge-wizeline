package com.wizeline.bootcamp.challenge.domain.usecases.pokemon

import com.wizeline.bootcamp.challenge.domain.repositories.PokemonRepository
import com.wizeline.bootcamp.challenge.domain.usecases.UseCaseResult

open class GetPokemonUseCase(private val pokemonRepository: PokemonRepository) {
    operator fun invoke(pokemonId: String): UseCaseResult {
        return pokemonRepository.getPokemon(pokemonId)
    }
}