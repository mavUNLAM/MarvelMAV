package com.unlam.marvel.data.network.model

import com.google.gson.annotations.SerializedName

data class Thumbnail(
    @SerializedName("path") val path: String,
    @SerializedName("extension") val extension: String
) {
    fun toUrl() : String {
        return "$path.$extension"
    }
}