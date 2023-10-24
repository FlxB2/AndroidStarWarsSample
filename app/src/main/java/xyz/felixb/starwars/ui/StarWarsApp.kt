package xyz.felixb.starwars.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Brands
import compose.icons.fontawesomeicons.brands.JediOrder
import xyz.felixb.starwars.ui.navigation.FilmsView
import xyz.felixb.starwars.ui.navigation.PersonView
import xyz.felixb.starwars.ui.navigation.PlanetView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StarWarsApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var showMenu by remember { mutableStateOf(false) }

    Column {
        TopAppBar(
            title = {
                Text(text = getRouteNameFromBackStackEntry(navBackStackEntry))
            },
            navigationIcon = {
                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(32.dp),
                    imageVector = FontAwesomeIcons.Brands.JediOrder,
                    contentDescription = "The Jedi Order Logo"
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                // Uses colors based on Material One color system
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                actionIconContentColor = MaterialTheme.colorScheme.onSecondary
            ),
            actions = {
                IconButton(onClick = { showMenu = !showMenu }) {
                    Icon(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(32.dp),
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Menu to switch between lists"
                    )
                }
                DropdownMenu(
                    expanded = showMenu,
                    onDismissRequest = { showMenu = false }
                ) {
                    routeToTranslation.entries.forEach { (route, text) ->
                        DropdownMenuItem(
                            onClick = {
                                navController.navigate(route)
                                showMenu = false
                            },
                            text = { Text(text = text) })
                    }
                }
            }
        )
        NavHost(
            navController = navController,
            startDestination = NavDestinations.LIST_OF_CHARACTERS.route
        ) {
            composable(NavDestinations.LIST_OF_CHARACTERS.route) {
                PersonView()
            }
            composable(NavDestinations.LIST_OF_PLANETS.route) {
                PlanetView()
            }
            composable(NavDestinations.LIST_OF_FILMS.route) {
                FilmsView()
            }
        }
    }
}

private fun getRouteNameFromBackStackEntry(backStackEntry: NavBackStackEntry?) =
    backStackEntry?.destination?.route?.let { routeToTranslation[it] } ?: ""

enum class NavDestinations(val route: String) {
    LIST_OF_CHARACTERS("characters"),
    LIST_OF_PLANETS("planets"),
    LIST_OF_FILMS("films")
}

private val routeToTranslation = mapOf(
    NavDestinations.LIST_OF_CHARACTERS.route to "Characters",
    NavDestinations.LIST_OF_PLANETS.route to "Planets",
    NavDestinations.LIST_OF_FILMS.route to "Films"
)