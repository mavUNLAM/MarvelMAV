package com.unlam.marvel.data.repository

import com.unlam.marvel.data.CharactersResponse
import com.unlam.marvel.data.MarvelCharactersClient
import com.unlam.marvel.domain.Character

class CharactersRepository(private val apiClient: MarvelCharactersClient) :
    ICharactersRepository {

    override suspend fun getCharacters(timestamp: Long, md5: String): List<Character> {
        return apiClient.getAllCharacters(timestamp, md5).toModel()
    }

    private fun CharactersResponse.toModel(): List<Character> {
        return this.characters.list.map {
            Character(
                id = it.id,
                name = it.name,
                description = it.description,
                thumbnailUrl = it.thumbnail.toUrl()
            )
        }
    }
}