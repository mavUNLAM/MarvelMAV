package com.unlam.marvel.data.network.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName

data class HeroNetworkData(
    @SerializedName("results")
    val list: List<HeroNetworkModel>
)

data class HeroKtorResult(
    @SerialName("results") val list: List<HeroKtorModel>
)
