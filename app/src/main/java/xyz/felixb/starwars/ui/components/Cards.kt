package xyz.felixb.starwars.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.swapi.client.models.Film
import dev.swapi.client.models.Person
import dev.swapi.client.models.Planet

@Composable
fun FilmCard(film: Film) {
    GenericCardItem {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Episode: ${film.episodeId}", fontWeight = FontWeight.Bold)
            Text(text = "Producer: ${film.producer}")
            Text(text = "Release Date: ${film.releaseDate}")
        }
    }
}

@Composable
fun PersonCard(person: Person) {
    GenericCardItem {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Name: ${person.name}", fontWeight = FontWeight.Bold)
            Text(text = "Gender: ${person.gender}")
            Text(text = "Birth Year: ${person.birthYear}")
        }
    }
}

@Composable
fun PlanetCard(planet: Planet) {
    GenericCardItem {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Name: ${planet.name}", fontWeight = FontWeight.Bold)
            Text(text = "Climate: ${planet.climate}")
        }
    }
}