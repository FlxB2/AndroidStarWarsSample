package xyz.felixb.starwars.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import xyz.felixb.starwars.data.SwapiRepository
import javax.inject.Inject

@HiltViewModel
class PlanetViewModel @Inject constructor(
    repository: SwapiRepository
): ViewModel() {
    val planets = repository.getPlanets().cachedIn(viewModelScope)
}