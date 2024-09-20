package com.unlam.marvel.data.network.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName

data class ThumbnailNetworkModel(
    @SerializedName("path") val path: String,
    @SerializedName("extension") val extension: String
) {
    fun toUrl() : String {
        return "$path.$extension"
    }
}

data class ThumbnailKtorModel(
    @SerialName("path") val path: String,
    @SerialName("extension") val extension: String
)

fun ThumbnailKtorModel.toUrl() = "$path.$extension"
