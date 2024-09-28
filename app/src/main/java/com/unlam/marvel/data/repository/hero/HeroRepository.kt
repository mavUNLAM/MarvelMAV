package com.unlam.marvel.data.repository.hero

import com.unlam.marvel.data.login.KeyData
import com.unlam.marvel.data.network.IMarvelClient
import com.unlam.marvel.data.network.model.toHeroList
import com.unlam.marvel.domain.Hero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HeroRepository(private val apiClient: IMarvelClient) :
    IHeroRepository {

    override fun getCharacters(keyData: KeyData, page: Int): Flow<List<Hero>> {
        val ktorResponse = apiClient
            .getCharacters(page = page, apiPublicKey = keyData.public, apiPrivateKey = keyData.private)
        return ktorResponse.map { response -> response.data.toHeroList() }
    }
}

/*
/**
     * Los personajes se ordenan de la siguiente manera:
     * - Primero los que tienen descripción, y luego los que no.
     * - Los que tienen descripción a su vez se ordenan ascendentemente por su id.
     * - Los que NO tienen descripción se ordenan descendentemente por su id.
     */
    private class CharacterComparator : Comparator<Hero> {
        override fun compare(c1: Hero, c2: Hero): Int {
            if (c1.description.isEmpty() && c2.description.isEmpty()) {
                return c2.id.compareTo(c1.id)
            }
            if (c1.description.isNotEmpty() && c2.description.isNotEmpty()) {
                return c1.id.compareTo(c2.id)
            }
            if (c1.description.isNotEmpty() && c2.description.isEmpty()) {
                return -1
            }
            return 1
        }

    }
 */
