package com.unlam.marvel.data.repository.hero

import com.unlam.marvel.data.login.KeyData
import com.unlam.marvel.domain.Hero
import kotlinx.coroutines.flow.Flow

interface IHeroRepository {
    suspend fun getCharacters(timestamp: Long, md5: String): List<Hero>
    suspend fun getCharacters(keyData: KeyData, page: Int): List<Hero>
    fun getCharactersFlow(timestamp: Long, md5: String): Flow<List<Hero>>
}
