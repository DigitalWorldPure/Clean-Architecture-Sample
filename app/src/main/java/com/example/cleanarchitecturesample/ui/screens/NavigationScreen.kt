package com.example.cleanarchitecturesample.ui.screens

sealed class NavigationScreen(val route: String) {
    object Detail : NavigationScreen("Detail")
    object Dialog : NavigationScreen("Dialog")
    object BottomSheet : NavigationScreen("BottomSheet")
}