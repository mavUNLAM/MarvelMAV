package com.unlam.marvel.ui.listscreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ListScreenViewmodel: ViewModel() {
    private val _state = MutableStateFlow(ListScreenState())
    val state = _state.asStateFlow()

}

class ListScreenState {

}
