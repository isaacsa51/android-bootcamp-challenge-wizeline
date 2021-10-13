package com.wizeline.bootcamp.challenge.domain.usecases.pokemon

import com.wizeline.bootcamp.challenge.domain.repositories.PokemonRepository
import com.wizeline.bootcamp.challenge.domain.usecases.UseCaseResult

class GetPokemonUseCase(private val pokemonRepository: PokemonRepository) {
    operator fun invoke(pokemonId: Long): UseCaseResult {
        return pokemonRepository.getPokemon(pokemonId)
    }
}