package com.example.yugiohkmm

import com.example.yugiohkmm.model.CardModel
import com.example.yugiohkmm.model.InfoModel
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class Greeting {
    private val platform: Platform = getPlatform()
    //var teste : CardModel = CardModel(0,"","", arrayListOf())
    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            })
        }
    }

    fun greeting(): String {
        return "Hello, ${platform.name}!"
    }

    suspend fun getCard(): CardModel {
        return client.get("https://db.ygoprodeck.com/api/v7/cardinfo.php").body()
    }
}