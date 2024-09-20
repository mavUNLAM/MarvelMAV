package com.unlam.marvel.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KtorData(
    @SerialName("count") val count: Int,
    @SerialName("limit") val limit: Int,
    @SerialName("offset") val offset: Int,
    @SerialName("results") val characterList: List<KtorHero>,
    @SerialName("total") val total: Int
)
