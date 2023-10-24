package xyz.felixb.starwars.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.filter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import xyz.felixb.starwars.data.SwapiRepository
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(
    repository: SwapiRepository
) : ViewModel() {

    val films =
        repository.getFilms()
            .cachedIn(viewModelScope).map { pagingData ->
                pagingData.filter {
                    // Prequels are overrated anyway..
                    it.episodeId == null || it.episodeId > 3
                }
            }
}