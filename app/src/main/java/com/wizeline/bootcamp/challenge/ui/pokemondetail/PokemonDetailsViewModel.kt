package com.wizeline.bootcamp.challenge.ui.pokemondetail

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wizeline.bootcamp.challenge.data.mock.PokemonDetails
import com.wizeline.bootcamp.challenge.di.RemoteGetPokemonUseCase
import com.wizeline.bootcamp.challenge.domain.usecases.UseCaseResult
import com.wizeline.bootcamp.challenge.domain.usecases.pokemon.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    @RemoteGetPokemonUseCase private val getPokemonDetails: GetPokemonUseCase,
) : ViewModel() {

    private val mutablePokemonInfo = MutableLiveData<PokemonDetails>()
    val pokemonInfo: LiveData<PokemonDetails> = mutablePokemonInfo

    private val mutableError: MutableLiveData<Boolean> = MutableLiveData()
    val error = mutableError as LiveData<Boolean>

    @WorkerThread
    fun initializeSearch(pokemonId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            getRemotePokemonInfo(pokemonId)
        }
    }

    private fun getRemotePokemonInfo(pokemonId: Long) {
        when (val result = getPokemonDetails(pokemonId)) {
            is UseCaseResult.Success -> {
                handleSuccessfulTagsFound(result)
            }
            is UseCaseResult.Error -> {
                handleGetTagsUseCaseError()
            }
        }
    }

    private fun handleSuccessfulTagsFound(result: UseCaseResult.Success) {
        val pokemon = result.getData() as PokemonDetails

        mutablePokemonInfo.postValue(pokemon)
    }

    private fun handleGetTagsUseCaseError() {
        mutableError.postValue(true)
    }
}