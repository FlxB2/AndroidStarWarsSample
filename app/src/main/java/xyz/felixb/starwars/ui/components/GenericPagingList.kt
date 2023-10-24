package xyz.felixb.starwars.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems

/**
 * A generic paging list that can be used for any type of content using LazyPagingItems.
 *
 * @param pagingItems The LazyPagingItems to use for the list
 * @param content The content to display for each item
 */
@Composable
fun <T : Any> GenericPagingList(
    pagingItems: LazyPagingItems<T>,
    content: @Composable (item: T) -> Unit
) {
    // Possible extension: pull to refresh
    when (pagingItems.loadState.refresh) {
        is LoadState.Error -> GenericError(msg = "Could not load characters")
        is LoadState.Loading -> LoadingIndicator()
        else -> LazyColumn(
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(count = pagingItems.itemCount, key = { index -> index }) { index ->
                val item = pagingItems[index] ?: return@items
                content(item)

                // As an extension we could add another box at the and which contains
                // grey placeholders, indicating the list is not loaded completely
                // if not all paging items have been retrieved yet
            }
        }
    }
}