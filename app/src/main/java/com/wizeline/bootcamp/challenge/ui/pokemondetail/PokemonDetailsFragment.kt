package com.wizeline.bootcamp.challenge.ui.pokemondetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
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
        val pokemonId = requireArguments().getLong(POKEMON_ID_EXTRA)

        setupViewModel(pokemonId)
    }

    private fun setupViewModel(pokemonId: Long){
        viewModel.pokemonInfo.observe(viewLifecycleOwner, selectedPokemonInfo)
        viewModel.error.observe(viewLifecycleOwner, checkPokemonInfo)

        viewModel.initializeSearch(pokemonId)
    }

    private val selectedPokemonInfo = Observer<PokemonDetails> { pokemon ->
        arrangePokemonDetails(pokemon)
    }

    private val checkPokemonInfo = Observer<Boolean> { error ->
        if (error) {
            binding.pokemonFrontSprite.visibility = View.GONE
            binding.pokemonBackSprite.visibility = View.GONE
            binding.guideline.visibility = View.GONE
            binding.pokemonAbilities.visibility = View.GONE
            binding.pokemonName.visibility = View.GONE
            binding.pokemonWeight.visibility = View.GONE
            binding.pokemonHeight.visibility = View.GONE

            binding.pokemonAbilities.visibility = View.VISIBLE
        } else {
            binding.pokemonFrontSprite.visibility = View.VISIBLE
            binding.pokemonBackSprite.visibility = View.VISIBLE
            binding.guideline.visibility = View.VISIBLE
            binding.pokemonAbilities.visibility = View.VISIBLE
            binding.pokemonName.visibility = View.VISIBLE
            binding.pokemonWeight.visibility = View.VISIBLE
            binding.pokemonHeight.visibility = View.VISIBLE

            binding.pokemonAbilities.visibility = View.GONE
        }
    }

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
            pokemonHeight.text = "Height: ${pokemonDetails.height}"
            pokemonWeight.text = "Weight: ${pokemonDetails.weight}"

            val abilitiesString = pokemonDetails.abilities.joinToString(
                separator = ", ",
                prefix = "Abilities: "
            ) {
                it.abilityDetail.name
            }
            pokemonAbilities.text = abilitiesString
        }
    }

    companion object {
        const val POKEMON_ID_EXTRA = "pokemon_id"
    }
}