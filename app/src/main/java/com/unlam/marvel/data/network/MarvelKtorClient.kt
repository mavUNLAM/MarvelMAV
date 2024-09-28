package com.unlam.marvel.data.network

import com.unlam.marvel.data.network.model.KtorResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.http.URLProtocol
import io.ktor.http.path
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.kotlincrypto.hash.md.MD5
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class MarvelKtorClient(
    private val client: HttpClient
):IMarvelClient {
    companion object {
        private const val LIST_SIZE_LIMIT = 100
        private const val CHARACTER_LIST_PATH = "v1/public/characters"
        private const val HOST = "gateway.marvel.com"
    }

    override fun getCharacters(page: Int, apiPublicKey: String, apiPrivateKey: String) = flow<KtorResponse> {
        val offset = (page - 1) * LIST_SIZE_LIMIT
        val timestamp = System.currentTimeMillis().toString()
        // val md5 = md5(timestamp + apiPrivateKey + apiPublickKey)
        val md5 = kotlinCryptoMd5(timestamp + apiPrivateKey + apiPublicKey)
        val response = client.request {
            url {
                protocol = URLProtocol.HTTPS
                host = HOST
                path(CHARACTER_LIST_PATH)
                parameters.append(name= "ts", value = timestamp)
                parameters.append(name = "apikey", value = apiPublicKey)
                parameters.append(name = "hash", value = md5)
                parameters.append(name = "orderBy", value = "name")
                parameters.append(name = "limit", value = LIST_SIZE_LIMIT.toString())
                parameters.append(name = "offset", value = offset.toString())
            }
        }.body<KtorResponse>()
        emit(response)
    }

    override fun getPageLimit(apiPublicKey: String, apiPrivateKey: String): Flow<Int> {
        TODO("Not yet implemented")
    }

    private fun md5(string: String): String {
        val MD5 = "MD5"
        try {
            // Create MD5 Hash
            val digest = MessageDigest
                .getInstance(MD5)
            digest.update(string.toByteArray())
            val messageDigest = digest.digest()

            // Create Hex String
            val hexString = StringBuilder()
            for (aMessageDigest in messageDigest) {
                var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
                while (h.length < 2) h = "0$h"
                hexString.append(h)
            }
            return hexString.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return ""
    }

    private fun kotlinCryptoMd5(string: String): String {
        val md5 = MD5()
        md5.update(string.toByteArray())
        val messageDigest = md5.digest()
        // Create Hex String
        val hexString = StringBuilder()
        for (aMessageDigest in messageDigest) {
            var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
            while (h.length < 2) h = "0$h"
            hexString.append(h)
        }
        return hexString.toString()
    }

    fun searchCharacters(query: String) = flow<KtorResponse> {

    }
}
