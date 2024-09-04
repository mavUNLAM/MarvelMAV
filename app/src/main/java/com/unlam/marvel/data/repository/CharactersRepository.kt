package com.unlam.marvel.data.repository

import com.unlam.marvel.data.network.model.CharactersResponse
import com.unlam.marvel.data.network.IMarvelCharactersClient
import com.unlam.marvel.domain.Character

class CharactersRepository(private val apiClient: IMarvelCharactersClient) :
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