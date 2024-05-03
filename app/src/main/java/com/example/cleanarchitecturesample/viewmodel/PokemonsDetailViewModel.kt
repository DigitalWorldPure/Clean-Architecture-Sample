package com.example.cleanarchitecturesample.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.PokemonDetails
import com.example.domain.usecases.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PokemonsDetailViewModel @Inject constructor(
    private val useCase: PokemonUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _detailsStateFlow = MutableStateFlow<PokemonDetails?>(null)
    val detailsStateFlow = _detailsStateFlow.asStateFlow()

    private val id = savedStateHandle.get<String>("id")

    init {
        viewModelScope.launch(Dispatchers.IO) {
            if (id != null) {
                val details = useCase.getDetail(id)
                _detailsStateFlow.value = details
            }
        }
    }
}