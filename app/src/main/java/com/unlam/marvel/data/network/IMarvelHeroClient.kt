package com.unlam.marvel.data.network

import com.unlam.marvel.data.network.model.HeroResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

// se usa en retrofit.create(IMarvelHeroClient::class.java)
interface IMarvelHeroClient {

    @GET("v1/public/characters")
    @Headers("Accept: application/json")
    suspend fun getAllCharacters(
        @Query("ts") timestamp: Long,
        @Query("hash") md5: String
    ): HeroResponse

}