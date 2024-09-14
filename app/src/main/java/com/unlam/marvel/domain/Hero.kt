package com.unlam.marvel.domain

data class Hero(
    val id: Long,
    val name: String,
    val description: String,
    val thumbnailUrl: String
) {
    companion object {
        fun exampleList(): List<Hero> {
            return (0..25).map {
                Hero(
                    id = it.toLong(),
                    name = "Héroe $it",
                    description = "Descripción del héroe $it",
                    thumbnailUrl = ""
                )
            }
        }
    }
}
