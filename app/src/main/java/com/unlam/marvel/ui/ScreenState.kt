package com.unlam.marvel.ui

import com.unlam.marvel.domain.Character

sealed class ScreenState {

    object Loading : ScreenState()

    class ShowCharacters(val list: List<Character>) : ScreenState()
}