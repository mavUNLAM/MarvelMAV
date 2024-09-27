package com.unlam.marvel.data.login

class LogInService : ILogInService {
    private val publicKey = "cfaf2296a6753090bb980a11945d9ec7"
    private val privateKey = "f86b2a5a3902e22678b7c18bafa08e07cf5f8b1e"

    override fun getKeys(): KeyData {
        return KeyData(
            publicKey,
            privateKey
        )
    }
}
