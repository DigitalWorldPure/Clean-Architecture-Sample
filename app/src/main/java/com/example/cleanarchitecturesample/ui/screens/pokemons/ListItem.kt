package com.example.cleanarchitecturesample.ui.screens.pokemons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.cleanarchitecturesample.ui.screens.NavigationScreen
import com.example.cleanarchitecturesample.ui.theme.CleanArchitectureSampleTheme
import com.example.domain.models.PokemonShortData

@Composable
fun ListItem(item: PokemonShortData?, navController: NavHostController? = null) {
    Card(modifier = Modifier.fillMaxWidth().padding(10.dp).clickable { navController?.navigate(NavigationScreen.Detail.route + "?id=${item?.name}") }) {
        Text(text = item?.name ?: "", modifier = Modifier.padding(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ListItemPreview() {
    CleanArchitectureSampleTheme {
        ListItem(PokemonShortData("Test pokemon", "test"))
    }
}