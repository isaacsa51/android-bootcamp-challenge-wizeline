package com.wizeline.bootcamp.challenge.data.repo

import com.wizeline.bootcamp.challenge.data.services.PokemonDetailsService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonDetailsRepo @Inject constructor(
    private val pokemonDetailsService: PokemonDetailsService
) {
    // TODO NETWORKING: Implement the getPokemonDetails(id) method
}
