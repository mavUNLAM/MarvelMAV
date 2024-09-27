package com.unlam.marvel.data.repository.hero

import com.unlam.marvel.data.network.model.HeroResponse
import com.unlam.marvel.data.network.IMarvelHeroClient
import com.unlam.marvel.data.login.KeyData
import com.unlam.marvel.domain.Hero
import kotlinx.coroutines.flow.Flow

class HeroRepository(private val apiClient: IMarvelHeroClient) :
    IHeroRepository {

    override suspend fun getCharacters(timestamp: Long, md5: String): List<Hero> {
        return apiClient.getAllCharacters(timestamp, md5).toModel()
    }

    override suspend fun getCharacters(keyData: KeyData, page: Int): List<Hero> {
        TODO("Not yet implemented")
    }

    override fun getCharactersFlow(timestamp: Long, md5: String): Flow<List<Hero>> {
        TODO("Not yet implemented")
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
