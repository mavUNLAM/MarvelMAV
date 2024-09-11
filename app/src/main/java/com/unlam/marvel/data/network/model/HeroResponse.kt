package com.unlam.marvel.data.network.model

import com.google.gson.annotations.SerializedName

data class HeroResponse(
    @SerializedName("data") val characters: HeroData
)