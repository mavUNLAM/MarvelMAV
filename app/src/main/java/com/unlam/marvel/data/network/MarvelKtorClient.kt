package com.unlam.marvel.data.network

import com.unlam.marvel.data.network.model.KtorResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.http.URLProtocol
import io.ktor.http.path
import kotlinx.coroutines.flow.flow
//import org.kotlincrypto.hash.md.MD5
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class MarvelKtorClient(
    private val client: HttpClient
) {
    companion object {
        private const val LIST_SIZE_LIMIT = 100
    }

    fun getCharacters(page: Int, apiPublickKey: String, apiPrivateKey: String) = flow<KtorResponse> {
        val offset = (page - 1) * LIST_SIZE_LIMIT
        /*val response = client
            .get(urlString = "https://gateway.marvel.com:443/v1/public/characters?orderBy=name&limit=$LIST_SIZE_LIMIT&offset=$offset&apikey=$apiPublicKey")
            .body<KtorResponse>()
        */
        /*
        generar timestamp y hash aquí.
         */
        val timestamp = System.currentTimeMillis().toString()
        val md5 = md5(timestamp + apiPrivateKey + apiPublickKey)
        val response = client.request {
            url {
                protocol = URLProtocol.HTTPS
                host = "gateway.marvel.com"
                path("v1/public/characters")
                parameters.append(name= "ts", value = timestamp)
                parameters.append(name = "apikey", value = apiPublickKey)
                parameters.append(name = "hash", value = md5)
                parameters.append(name = "orderBy", value = "name")
                parameters.append(name = "limit", value = LIST_SIZE_LIMIT.toString())
                parameters.append(name = "offset", value = offset.toString())
            }
        }.body<KtorResponse>()
        emit(response)
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

    fun searchCharacters(query: String) = flow<KtorResponse> {

    }
}
