package com.unlam.marvel.data.network.model

import com.google.gson.annotations.SerializedName

data class HeroData(
    @SerializedName("results")
    val list: List<HeroResult>
)