package com.example.cropify.network

import com.example.cropify.network.ApiConst.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header

actual fun createHttpClient(token: String): HttpClient {
    return HttpClient(Darwin) {
        defaultRequest {
            url(BASE_URL)
            header("dauth", token)
        }
    }
}