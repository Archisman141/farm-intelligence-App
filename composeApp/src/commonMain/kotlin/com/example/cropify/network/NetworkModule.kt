package com.example.cropify.network

import io.ktor.client.*
import org.koin.dsl.module


val networkModule = module {

    single {
        createHttpClient(get()) // token injected
    }
}

expect fun createHttpClient(token: String): HttpClient