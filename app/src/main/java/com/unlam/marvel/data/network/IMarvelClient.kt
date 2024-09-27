package com.unlam.marvel.data.network

import com.unlam.marvel.data.network.model.KtorResponse
import kotlinx.coroutines.flow.Flow

interface IMarvelClient {
    fun getCharacters(page: Int, apiPublicKey: String, apiPrivateKey: String) : Flow<KtorResponse>
    fun getPageLimit(apiPublicKey: String, apiPrivateKey: String): Flow<Int>
}
