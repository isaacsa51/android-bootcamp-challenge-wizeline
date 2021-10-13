package com.wizeline.bootcamp.challenge.data.repo

import androidx.annotation.WorkerThread
import com.wizeline.bootcamp.challenge.data.errors.ErrorCodes
import com.wizeline.bootcamp.challenge.data.services.PokemonDetailsService
import com.wizeline.bootcamp.challenge.domain.repositories.PokemonRepository
import com.wizeline.bootcamp.challenge.domain.usecases.UseCaseResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonDetailsRepo @Inject constructor(
    private val pokemonDetailsService: PokemonDetailsService
) : PokemonRepository {
    @WorkerThread
    override fun getPokemon(pokemonId: Long): UseCaseResult {
        try {
            val response = pokemonDetailsService.getPokemon(pokemonId).execute()

            if (response.isSuccessful) {
                val pokemonDto = response.body()
                    ?: return UseCaseResult.Error(ErrorCodes.OK_BUT_INFO_NOT_AVAILABLE)
                return UseCaseResult.Success(pokemonDto)
            } else {
                return UseCaseResult.Error(response.code())
            }
        } catch (e: Exception) {
            return UseCaseResult.Error(ErrorCodes.EXCEPTION_ON_REQUEST, e)
        }
    }
}
