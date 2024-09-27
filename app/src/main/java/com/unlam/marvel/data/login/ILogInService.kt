package com.unlam.marvel.data.login

interface ILogInService {
    fun getKeys(): KeyData
}

data class KeyData(
    val public: String,
    val private: String
)
