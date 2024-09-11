package com.unlam.marvel.data.repository

import com.unlam.marvel.domain.Hero

interface IHeroRepository {
    suspend fun getCharacters(timestamp: Long, md5: String): List<Hero>
}
