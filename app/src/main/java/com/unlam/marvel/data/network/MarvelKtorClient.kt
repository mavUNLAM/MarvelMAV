package com.unlam.marvel.data.network

import com.unlam.marvel.data.network.model.HeroKtorResponse
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.flow

class MarvelKtorClient(
    private val apiPublicKey: String,
    private val apiPrivateKey: String,
    private val client: HttpClient
) {
    fun getCharacters(page: Int) = flow<HeroKtorResponse> {

    }
}
