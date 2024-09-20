package com.unlam.marvel.data.network.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName

data class HeroResponse(
    @SerializedName("data") val characters: HeroNetworkData
)

data class HeroKtorResponse(
    @SerialName("data") val characters: HeroKtorResult
)
