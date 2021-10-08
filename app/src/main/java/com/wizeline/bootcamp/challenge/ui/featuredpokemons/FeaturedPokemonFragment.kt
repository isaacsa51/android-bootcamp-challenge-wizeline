package com.wizeline.bootcamp.challenge.ui.featuredpokemons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wizeline.bootcamp.challenge.data.mock.mockPokemons
import com.wizeline.bootcamp.challenge.databinding.FragmentFeaturedPokemonBinding
import dagger.hilt.android.AndroidEntryPoint

// view holders' height should take 1/7 of the screen
private const val VIEW_HOLDER_SCREEN_PROPORTION = 1.0 / 7.0

@AndroidEntryPoint
class FeaturedPokemonFragment : Fragment() {

    private var _binding: FragmentFeaturedPokemonBinding? = null
    private val binding: FragmentFeaturedPokemonBinding
        get() = _binding!!

    private lateinit var navController: NavController

    private lateinit var pokemonAdapter: FeaturedPokemonAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentFeaturedPokemonBinding
            .inflate(layoutInflater, container, false)
            .apply { _binding = this }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pokemonAdapter = FeaturedPokemonAdapter { pokemonId ->
            FeaturedPokemonFragmentDirections
                .toPokemonDetailFragment(pokemonId)
                .let { navController.navigate(it) }
        }
        navController = findNavController()
        binding.featuredPokemonList.run {
            adapter = pokemonAdapter
            layoutManager = object : LinearLayoutManager(requireContext()) {
                override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
                    lp?.height = (height * VIEW_HOLDER_SCREEN_PROPORTION).toInt()
                    return true
                }
            }
        }
        pokemonAdapter.submitList(mockPokemons)
    }
}