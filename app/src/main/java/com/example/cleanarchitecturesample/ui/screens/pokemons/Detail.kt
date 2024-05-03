package com.example.cleanarchitecturesample.ui.screens.pokemons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.cleanarchitecturesample.ui.theme.CleanArchitectureSampleTheme
import com.example.cleanarchitecturesample.viewmodel.PokemonsDetailViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cleanarchitecturesample.R

@Composable
fun Detail(navController: NavHostController? = null) {
    val pokemonDetailsViewModel = hiltViewModel<PokemonsDetailViewModel>()
    val detail by pokemonDetailsViewModel.detailsStateFlow.collectAsState()
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        if (detail != null) {
            Column(modifier = Modifier.fillMaxSize()) {
                AsyncImage(
                    model = detail?.sprites?.frontDefault,
                    contentDescription = stringResource(R.string.default_pokemon_image),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )

                Text(
                    text = "${detail?.name}",
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                )
                Text(
                    text = stringResource(R.string.pokemon_height, detail?.height ?: ""),
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
        else {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .wrapContentSize()
            )
        }


        /*Button(onClick = { navController?.navigate(NavigationScreen.Dialog.route) }) {
            Text(text = "Open dialog")
        }
        Button(onClick = { navController?.navigate(NavigationScreen.BottomSheet.route) }) {
            Text(text = "Open BottomSheet")
        }*/
    }
}

@Preview(showBackground = true, apiLevel = 33)
@Composable
fun DetailPreview() {
    CleanArchitectureSampleTheme {
        Detail()
    }
}