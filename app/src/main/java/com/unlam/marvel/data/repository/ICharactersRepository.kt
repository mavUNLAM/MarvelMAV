package com.unlam.marvel.data.repository

import com.unlam.marvel.domain.Character

interface ICharactersRepository {
    suspend fun getCharacters(timestamp: Long, md5: String): List<Character>
}