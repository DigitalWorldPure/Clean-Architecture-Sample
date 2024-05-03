package com.example.cleanarchitecturesample.ui.screens

import androidx.annotation.StringRes
import com.example.cleanarchitecturesample.R

sealed class BottomNavigationScreen(val route: String, @StringRes val resourceId: Int) {
    object Home : BottomNavigationScreen("Home", R.string.home_bottom_menu)
    object List : BottomNavigationScreen("List", R.string.list_bottom_menu)
}
