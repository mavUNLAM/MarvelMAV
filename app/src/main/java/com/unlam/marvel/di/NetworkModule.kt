package com.unlam.marvel.di

import com.unlam.marvel.data.network.IMarvelHeroClient
import com.unlam.marvel.data.network.PublicKeyInterceptor
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(PublicKeyInterceptor())
            .build()
    }
    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl("https://gateway.marvel.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IMarvelHeroClient::class.java)
    }
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
}
