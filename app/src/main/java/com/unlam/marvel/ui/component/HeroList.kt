package com.unlam.marvel.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unlam.marvel.domain.Hero

@Preview(showBackground = true)
@Composable
fun CharacterList(
    modifier: Modifier = Modifier,
    list: List<Hero> = Hero.exampleList(),
    onHeroClick: (Int) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier,
        state = rememberLazyListState(),
    ) {
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                text = "Lista de héroes"
            )
        }
        items(list) {
            HeroItem(it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeroItem(
    hero: Hero = Hero(
        id = 0,
        name = "Hero",
        description = "Description",
        thumbnailUrl = ""
    )
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "${hero.name} foto"
        )
        Text(
            text = hero.description
        )
    }
}
