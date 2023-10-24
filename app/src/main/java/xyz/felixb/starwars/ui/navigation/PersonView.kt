package xyz.felixb.starwars.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import dev.swapi.client.models.Person
import xyz.felixb.starwars.ui.components.CharacterCard
import xyz.felixb.starwars.ui.components.GenericError
import xyz.felixb.starwars.ui.components.LoadingIndicator
import xyz.felixb.starwars.viewmodels.PeopleViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PersonView(viewModel: PeopleViewModel = hiltViewModel()) {
    val pageItems: LazyPagingItems<Person> = viewModel.people.collectAsLazyPagingItems()

    when (pageItems.loadState.refresh) {
        is LoadState.Error -> GenericError(msg = "Could not load characters")
        is LoadState.Loading -> LoadingIndicator()
        else -> LazyColumn(
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(count = pageItems.itemCount, key = { index -> index }) { index ->
                val person = pageItems[index] ?: return@items
                Box(modifier = Modifier.animateItemPlacement()) {
                    CharacterCard(person)
                }
            }
        }
    }

}
