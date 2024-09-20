package com.unlam.marvel.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/*
ktorResponse
----ktorData
-------ktorCharacterList
----------ktorThumbnail
 */
@Serializable
data class KtorResponse(
    @SerialName("code") val code: Int,
    @SerialName("data") val data: KtorData,
    @SerialName("status") val status: String
)
