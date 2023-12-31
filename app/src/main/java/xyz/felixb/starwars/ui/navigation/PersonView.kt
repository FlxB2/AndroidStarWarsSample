package xyz.felixb.starwars.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import xyz.felixb.starwars.ui.components.PersonCard
import xyz.felixb.starwars.ui.components.GenericPagingList
import xyz.felixb.starwars.viewmodels.PersonViewModel

@Composable
fun PersonView(viewModel: PersonViewModel = hiltViewModel()) {
    val pageItems = viewModel.people.collectAsLazyPagingItems()

    GenericPagingList(pagingItems = pageItems) {
        PersonCard(person = it)
    }
}
