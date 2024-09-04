package com.unlam.marvel.data.network.model

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("data") val characters: CharacterData
)