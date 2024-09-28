package com.unlam.marvel.di

import com.unlam.marvel.data.network.IMarvelClient
import com.unlam.marvel.data.network.MarvelKtorClient
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module


val networkModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }
    single<IMarvelClient> {
        MarvelKtorClient(get())
    }
}
