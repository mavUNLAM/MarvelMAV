package com.unlam.marvel.data.repository.hero

import com.unlam.marvel.data.login.KeyData
import com.unlam.marvel.domain.Hero
import kotlinx.coroutines.flow.Flow

interface IHeroRepository {
    fun getCharacters(keyData: KeyData, page: Int): Flow<List<Hero>>
}
