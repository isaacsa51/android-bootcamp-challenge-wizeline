package com.wizeline.bootcamp.challenge.ui.pokemondetail

import androidx.lifecycle.ViewModel
import com.wizeline.bootcamp.challenge.data.repo.PokemonDetailsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val pokemonDetailsRepo: PokemonDetailsRepo
) : ViewModel() {

    // TODO DESIGN PATTERNS: Implement a function that communicates with the PokemonDetailsRepo to get the needed info.
}
