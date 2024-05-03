package com.example.cleanarchitecturesample.ui.screens.pokemons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cleanarchitecturesample.ui.theme.CleanArchitectureSampleTheme

@Composable
fun ListProgressItem() {
    CircularProgressIndicator(
        modifier = Modifier.fillMaxWidth()
            .padding(10.dp)
            .wrapContentSize()
    )
}

@Preview(showBackground = true)
@Composable
fun ListProgressItemPreview() {
    CleanArchitectureSampleTheme {
        ListProgressItem()
    }
}