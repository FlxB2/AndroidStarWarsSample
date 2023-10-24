package xyz.felixb.starwars.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import xyz.felixb.starwars.ui.components.GenericPagingList
import xyz.felixb.starwars.ui.components.PlanetCard
import xyz.felixb.starwars.viewmodels.PlanetViewModel

@Composable
fun PlanetView(viewModel: PlanetViewModel = hiltViewModel()) {
    val pagingItems = viewModel.planets.collectAsLazyPagingItems()

    GenericPagingList(pagingItems) { planet ->
        PlanetCard(planet)
    }
}
