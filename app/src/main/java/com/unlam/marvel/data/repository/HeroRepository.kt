package com.unlam.marvel.data.repository

import com.unlam.marvel.data.network.model.HeroResponse
import com.unlam.marvel.data.network.IMarvelHeroClient
import com.unlam.marvel.domain.Hero

class HeroRepository(private val apiClient: IMarvelHeroClient) :
    IHeroRepository {

    override suspend fun getCharacters(timestamp: Long, md5: String): List<Hero> {
        return apiClient.getAllCharacters(timestamp, md5).toModel()
    }

    private fun HeroResponse.toModel(): List<Hero> {
        return this.characters.list.map {
            Hero(
                id = it.id,
                name = it.name,
                description = it.description,
                thumbnailUrl = it.thumbnail.toUrl()
            )
        }
    }
}