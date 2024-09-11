package com.unlam.marvel.data.repository

import com.unlam.marvel.domain.Hero
import kotlinx.coroutines.flow.Flow

interface IHeroRepository {
    suspend fun getCharacters(timestamp: Long, md5: String): List<Hero>
    fun getCharactersFlow(timestamp: Long, md5: String): Flow<List<Hero>>
}
