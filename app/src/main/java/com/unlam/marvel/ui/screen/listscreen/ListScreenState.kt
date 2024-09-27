package com.unlam.marvel.ui.screen.listscreen

import com.unlam.marvel.domain.Hero

sealed class ListScreenState {
    data object Loading : ListScreenState()
    data object Error : ListScreenState()
    class ShowCharacters(val list: List<Hero>) : ListScreenState()
}
