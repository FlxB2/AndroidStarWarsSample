package xyz.felixb.starwars.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import xyz.felixb.starwars.ui.navigation.PersonView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StarWarsApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

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
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                actionIconContentColor = MaterialTheme.colorScheme.onSecondary
            )
        )
        NavHost(
            navController = navController,
            startDestination = NavDestinations.LIST_OF_CHARACTERS.route
        ) {
            composable(NavDestinations.LIST_OF_CHARACTERS.route) {
                PersonView()
            }
        }
    }
}

private fun getRouteNameFromBackStackEntry(backStackEntry: NavBackStackEntry?) =
    backStackEntry?.destination?.route?.let { routeToTranslation[it] } ?: ""

enum class NavDestinations(val route: String) {
    LIST_OF_CHARACTERS("characters"),
    CHARACTER_DETAILS("character_details")
}

private val routeToTranslation = mapOf(
    NavDestinations.LIST_OF_CHARACTERS.route to "Characters",
    NavDestinations.CHARACTER_DETAILS.route to "Character Details"
)