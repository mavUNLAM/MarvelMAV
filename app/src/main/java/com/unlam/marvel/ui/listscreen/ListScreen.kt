package com.unlam.marvel.ui.listscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.unlam.marvel.domain.Hero
import com.unlam.marvel.ui.component.CharacterList

@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    viewmodel: ListScreenViewmodel,
    onHeroClick: (Int) -> Unit
) {

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
