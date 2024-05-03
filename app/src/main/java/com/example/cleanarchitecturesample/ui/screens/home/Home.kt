package com.example.cleanarchitecturesample.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cleanarchitecturesample.ui.screens.main.MainContainer
import com.example.cleanarchitecturesample.ui.theme.CleanArchitectureSampleTheme

@Composable
fun Home(navController: NavHostController? = null) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("This is an example of a clean architecture application")
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    CleanArchitectureSampleTheme {
        Home()
    }
}
