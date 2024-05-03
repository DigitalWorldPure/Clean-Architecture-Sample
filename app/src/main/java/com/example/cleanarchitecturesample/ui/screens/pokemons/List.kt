package com.example.cleanarchitecturesample.ui.screens.pokemons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.example.cleanarchitecturesample.ui.theme.CleanArchitectureSampleTheme
import com.example.cleanarchitecturesample.viewmodel.PokemonsListViewModel

@Composable
fun List(navController: NavHostController? = null) {
    val pokemonViewModel = hiltViewModel<PokemonsListViewModel>()
    val data = pokemonViewModel.data.collectAsLazyPagingItems()
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(
                count = data.itemCount,
                key = data.itemKey(),
                contentType = data.itemContentType()
            ) { index ->
                val item = data[index]
                ListItem(item, navController)
            }
            if (data.loadState.append == LoadState.Loading) {
                item {
                    ListProgressItem()
                }
            }
        }
        if (data.loadState.refresh == LoadState.Loading) {
            ListProgressItem()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    CleanArchitectureSampleTheme {
        List()
    }
}