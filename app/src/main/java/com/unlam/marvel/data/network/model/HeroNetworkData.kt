package com.unlam.marvel.data.network.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class HeroNetworkData(
    @SerializedName("results")
    val list: List<HeroNetworkModel>
)

@Serializable
data class HeroKtorResult(
    @SerialName("results") val list: List<HeroKtorModel>
)
