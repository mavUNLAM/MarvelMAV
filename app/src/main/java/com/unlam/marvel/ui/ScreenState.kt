package com.unlam.marvel.ui

import com.unlam.marvel.domain.Hero

sealed class ScreenState {

    object Loading : ScreenState()

    class ShowCharacters(val list: List<Hero>) : ScreenState()
}
