package xyz.felixb.starwars.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import xyz.felixb.starwars.viewmodels.PeopleViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.openapitools.client.models.Person

@Composable
fun StarWarsApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            Test()
        }
    }
}

@Composable
fun Test(viewModel: PeopleViewModel = hiltViewModel()) {
    val people: LazyPagingItems<Person> = viewModel.people.collectAsLazyPagingItems()

    LazyColumn {
        items(count = people.itemCount,
            key = { index -> index }) { index ->
            val person = people[index] ?: return@items
            PersonItem(person)
        }
    }
}


@Composable
fun PersonItem(person: Person) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Name: ${person.name}")
        Text(text = "Birthyear: ${person.birthYear}")
    }
}