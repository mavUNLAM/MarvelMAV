package com.unlam.marvel.data.network.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class HeroResponse(
    @SerializedName("data") val characters: HeroNetworkData
)

@Serializable
data class HeroKtorResponse(
    @SerialName("data") val characters: HeroKtorResult
)
