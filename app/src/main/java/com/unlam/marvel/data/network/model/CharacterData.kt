package com.unlam.marvel.data.network.model

import com.google.gson.annotations.SerializedName

data class CharacterData(
    @SerializedName("results")
    val list: List<CharacterResult>
)