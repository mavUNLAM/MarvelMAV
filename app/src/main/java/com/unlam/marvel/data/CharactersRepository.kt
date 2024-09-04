package com.unlam.marvel.data

import com.unlam.marvel.domain.Character

interface CharactersRepository {
    suspend fun getCharacters(timestamp: Long, md5: String): List<Character>
}