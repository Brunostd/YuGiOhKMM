package com.example.yugiohkmm

import io.ktor.client.*

interface Platform {
    val name: String
}

expect fun httpClient(config: HttpClientConfig<*>.() -> Unit = {}): HttpClient
expect fun getPlatform(): Platform