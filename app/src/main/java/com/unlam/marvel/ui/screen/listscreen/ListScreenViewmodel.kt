package com.unlam.marvel.ui.screen.listscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unlam.marvel.data.login.ILogInService
import com.unlam.marvel.data.login.KeyData
import com.unlam.marvel.data.repository.hero.IHeroRepository
import com.unlam.marvel.domain.Hero
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class ListScreenViewmodel(
    private val characterRepository: IHeroRepository,
    private val loginService: ILogInService
): ViewModel() {
    private val _screenState = MutableStateFlow<ListScreenState>(ListScreenState.Loading)
    val screenState = _screenState.asStateFlow()

    private var currentPage = 1
    private var currentList: List<Hero> = emptyList()

    private var keyData = KeyData("", "")

    init {
        viewModelScope.launch {
            keyData = loginService.getKeys()
            characterRepository.getCharacters(keyData = keyData, page = currentPage).collect { list ->
                currentList = list
                _screenState.value = ListScreenState.ShowCharacters(list)
            }
        }
    }

    fun loadNextPage() {
        viewModelScope.launch {
            currentPage++
            characterRepository.getCharacters(keyData = keyData, page = currentPage).collect { nextPage ->
                currentList = currentList + nextPage
                _screenState.value = ListScreenState.ShowCharacters(currentList)
            }
        }
    }
}
