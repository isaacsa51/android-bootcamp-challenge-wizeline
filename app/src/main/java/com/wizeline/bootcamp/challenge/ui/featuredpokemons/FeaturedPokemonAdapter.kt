package com.wizeline.bootcamp.challenge.ui.featuredpokemons

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wizeline.bootcamp.challenge.R
import com.wizeline.bootcamp.challenge.databinding.ItemFeaturedPokemonBinding
import com.wizeline.bootcamp.challenge.domain.models.Pokemon

typealias OnPokemonClicked = (Long) -> Unit

class FeaturedPokemonAdapter(
    private val onPokemonClicked: OnPokemonClicked,
) : ListAdapter<Pokemon, FeaturedPokemonAdapter.PokemonViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return LayoutInflater.from(parent.context)
            .let { inflater -> ItemFeaturedPokemonBinding.inflate(inflater, parent, false) }
            .let { binding -> PokemonViewHolder(binding, onPokemonClicked) }
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PokemonViewHolder(
        private val binding: ItemFeaturedPokemonBinding,
        private val onPokemonClicked: OnPokemonClicked,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(pokemon: Pokemon) {
            binding.itemPokemonCount.text = pokemon.id.toString()
            binding.itemPokemonName.text = pokemon.name

            Glide.with(itemView.context).load(pokemon.spriteUrl)
                .placeholder(R.drawable.ic_baseline_photo_placeholder)
                .into(binding.itemPokemonImage)

            itemView.setOnClickListener {
                Log.i("onClick", "${pokemon.name} clicked!")
                onPokemonClicked(pokemon.id)
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Pokemon>() {
            override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean =
                oldItem == newItem
        }
    }
}