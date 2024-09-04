package com.unlam.marvel.data.network

import com.unlam.marvel.data.network.model.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

// se usa en retrofit.create(IMarvelCharactersClient::class.java)
interface IMarvelCharactersClient {

    @GET("v1/public/characters")
    @Headers("Accept: application/json")
    suspend fun getAllCharacters(
        @Query("ts") timestamp: Long,
        @Query("hash") md5: String
    ): CharactersResponse

}