package com.unlam.marvel.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class KtorThumbnail(
    @SerialName("extension") val extension: String,
    @SerialName("path") val path: String
)

fun KtorThumbnail.toUrl() = "$path.$extension"
