package com.unlam.marvel.data.network.model

import com.google.gson.annotations.SerializedName

data class HeroResult(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("thumbnail") val thumbnail: Thumbnail
)