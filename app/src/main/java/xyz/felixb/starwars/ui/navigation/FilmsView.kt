package xyz.felixb.starwars.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import xyz.felixb.starwars.ui.components.FilmCard
import xyz.felixb.starwars.ui.components.GenericPagingList
import xyz.felixb.starwars.viewmodels.FilmsViewModel

@Composable
fun FilmsView(viewModel: FilmsViewModel = hiltViewModel()) {
    val pageItems = viewModel.films.collectAsLazyPagingItems()

    GenericPagingList(pagingItems = pageItems) {
        FilmCard(it)
    }
}