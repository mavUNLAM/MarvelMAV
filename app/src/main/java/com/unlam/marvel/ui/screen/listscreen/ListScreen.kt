package com.unlam.marvel.ui.screen.listscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.unlam.marvel.domain.Hero
import com.unlam.marvel.ui.component.CharacterList

@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    viewmodel: ListScreenViewmodel,
    onHeroClick: (Int) -> Unit = {}
) {
    val screenState = viewmodel.screenState.collectAsStateWithLifecycle()
    when (val state = screenState.value) {
        is ListScreenState.ShowCharacters -> ListUi(
            modifier = modifier.fillMaxSize(),
            list = state.list,
            onHeroClick = onHeroClick
        )
        ListScreenState.Error -> TODO()
        ListScreenState.Loading -> CircularProgressIndicator()
    }
}

@Preview(showBackground = true)
@Composable
fun ListUi(
    modifier: Modifier = Modifier,
    list: List<Hero> = Hero.exampleList(),
    onHeroClick: (Int) -> Unit = {},
    onSearchList: (String) -> Unit = {}
    ) {
    Box(modifier = modifier) {
        Text(text = "imagen de fondo")
        Column {
            Text(text = "buscador")
            CharacterList(list = list, onHeroClick = onHeroClick)
        }
    }
}
