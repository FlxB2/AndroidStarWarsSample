package xyz.felixb.starwars.viewmodels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import xyz.felixb.starwars.repos.SwapiRepository
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    repository: SwapiRepository
): ViewModel() {
    val people = repository.getPersons()
}