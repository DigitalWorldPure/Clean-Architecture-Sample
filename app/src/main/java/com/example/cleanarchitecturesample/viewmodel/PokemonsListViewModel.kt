package com.example.cleanarchitecturesample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.models.PokemonShortData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PokemonsListViewModel @Inject constructor(pager: Flow<PagingData<PokemonShortData>>): ViewModel() {
    val data = pager.cachedIn(viewModelScope)
}