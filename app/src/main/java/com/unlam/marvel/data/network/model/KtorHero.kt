package com.unlam.marvel.data.network.model

import com.unlam.marvel.domain.Hero
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KtorHero(
    @SerialName("id") val id: Long,
    @SerialName("name") val name: String,
    @SerialName("description") val description: String,
    @SerialName("thumbnail") val thumbnail: KtorThumbnail,
)

fun KtorHero.toHero(): Hero {
    return Hero(
        id = id,
        name = name,
        description = description,
        thumbnailUrl = thumbnail.toUrl()
    )
}
