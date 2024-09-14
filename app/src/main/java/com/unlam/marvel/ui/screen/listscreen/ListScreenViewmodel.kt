package com.unlam.marvel.ui.screen.listscreen

import androidx.lifecycle.ViewModel
import com.unlam.marvel.data.repository.IHeroRepository
import com.unlam.marvel.domain.Hero
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ListScreenViewmodel(val characterRepository: IHeroRepository): ViewModel() {
    private val _screenState = MutableStateFlow(ListScreenState.Loading)
    val screenState = _screenState.asStateFlow()

}

sealed class ListScreenState {
    data object Loading : ListScreenState()
    data object Error : ListScreenState()
    class ShowCharacters(val list: List<Hero>) : ListScreenState()
}
