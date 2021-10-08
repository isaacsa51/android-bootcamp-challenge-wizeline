package com.wizeline.bootcamp.challenge.ui.pokemondetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.wizeline.bootcamp.challenge.data.mock.PokemonDetails
import com.wizeline.bootcamp.challenge.databinding.FragmentPokemonDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetailsFragment : Fragment() {

    private var _binding: FragmentPokemonDetailsBinding? = null
    private val binding: FragmentPokemonDetailsBinding
        get() = _binding!!

    private val viewModel: PokemonDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentPokemonDetailsBinding
            .inflate(inflater, container, false)
            .apply { _binding = this }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val pokemonId = requireArguments().getLong("pokemon_id")
        // TODO DESIGN PATTERNS: make your call to your view model here
    }

    // Tip: use this function to set up the data in the fragment views
    private fun arrangePokemonDetails(pokemonDetails: PokemonDetails) {
        Glide.with(requireContext())
            .load(pokemonDetails.sprites.frontDefault)
            .fitCenter()
            .into(binding.pokemonFrontSprite)

        Glide.with(requireContext())
            .load(pokemonDetails.sprites.backDefault)
            .fitCenter()
            .into(binding.pokemonBackSprite)

        binding.run {
            pokemonName.text = pokemonDetails.name.replaceFirstChar {
                it.uppercaseChar()
            }.let { "Name: $it" }
            pokemonHeight.text = "Height: ${pokemonDetails.height.toString()}"
            pokemonWeight.text = "Weight: ${pokemonDetails.weight.toString()}"

            val abilitiesString = pokemonDetails.abilities.joinToString(
                separator = ", ",
                prefix = "Abilities: "
            ) {
                it.abilityDetail.name
            }
            pokemonAbilities.text = abilitiesString
        }
    }
}