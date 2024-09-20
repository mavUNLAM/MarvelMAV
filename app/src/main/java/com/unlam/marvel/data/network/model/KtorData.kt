package com.unlam.marvel.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class KtorData(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<KtorHero>,
    val total: Int
)
