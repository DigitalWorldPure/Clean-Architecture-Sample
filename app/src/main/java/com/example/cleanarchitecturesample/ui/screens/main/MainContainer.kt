package com.example.cleanarchitecturesample.ui.screens.main

import android.app.Activity
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cleanarchitecturesample.R
import com.example.cleanarchitecturesample.ui.screens.BottomNavigationScreen
import com.example.cleanarchitecturesample.ui.screens.NavigationScreen
import com.example.cleanarchitecturesample.ui.screens.home.Home
import com.example.cleanarchitecturesample.ui.screens.pokemons.AdditionalInfoBottomSheet
import com.example.cleanarchitecturesample.ui.screens.pokemons.Detail
import com.example.cleanarchitecturesample.ui.screens.pokemons.List
import com.example.cleanarchitecturesample.ui.screens.pokemons.SearchErrorDialogScreen
import com.example.cleanarchitecturesample.ui.theme.CleanArchitectureSampleTheme
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.bottomSheet
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


val bottomNavigationItems = listOf(
    BottomNavigationScreen.Home,
    BottomNavigationScreen.List
)

val icons = listOf(
    Icons.Filled.Home,
    Icons.Filled.Menu
)

@OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MainContainer() {
    val bottomSheetNavigator = rememberBottomSheetNavigator()
    val defaultScrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
    val emptyScrollBehavior =
        TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val activity = LocalContext.current as? Activity
    var currentBehavior by remember {  mutableStateOf(emptyScrollBehavior) }

    val navigator = rememberNavController(bottomSheetNavigator).apply {
        addOnDestinationChangedListener { _, destination, _ ->
            currentBehavior = if (destination.route == BottomNavigationScreen.List.route)
                defaultScrollBehavior
            else
                emptyScrollBehavior
        }
    }

    Scaffold(
        modifier = Modifier.nestedScroll(currentBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.app_name))
                },
                navigationIcon = {
                    IconButton(onClick = {
                        if (!navigator.popBackStack()) {
                            activity?.finish()
                        }
                    }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            null
                        )
                    }
                },
                scrollBehavior = currentBehavior
            )
        },
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navigator.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                bottomNavigationItems.forEachIndexed { index, screen ->
                    BottomNavigationItem(
                        icon = { Icon(icons[index], contentDescription = null) },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navigator.navigate(screen.route) {
                                popUpTo(navigator.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        ModalBottomSheetLayout(bottomSheetNavigator) {
            NavHost(
                navigator,
                startDestination = BottomNavigationScreen.Home.route,
                Modifier.padding(innerPadding)
            ) {
                composable(BottomNavigationScreen.Home.route) { Home(navigator) }
                composable(BottomNavigationScreen.List.route) { List(navigator) }
                composable(
                    NavigationScreen.Detail.route + "?id={id}",
                    arguments = listOf(navArgument("id") {
                        type = NavType.StringType
                    })
                ) { backStackEntry ->
                    Detail(navigator)
                }
                dialog(NavigationScreen.Dialog.route) { SearchErrorDialogScreen(navigator) }
                bottomSheet(NavigationScreen.BottomSheet.route) {
                    AdditionalInfoBottomSheet(
                        navigator
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainContainerPreview() {
    CleanArchitectureSampleTheme {
        MainContainer()
    }
}