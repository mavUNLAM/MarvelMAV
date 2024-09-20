package com.unlam.marvel.data.network.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName

data class HeroNetworkModel(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("thumbnail") val thumbnail: ThumbnailNetworkModel
)

data class HeroKtorModel(
    @SerialName("id") val id: Long,
    @SerialName("name") val name: String,
    @SerialName("description") val description: String,
    @SerialName("thumbnail") val thumbnail: ThumbnailNetworkModel
)
