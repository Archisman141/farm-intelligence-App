package com.example.cropify.network


import android.content.Context
import com.example.cropify.network.ApiConst.BASE_URL
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.header
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import okhttp3.internal.platform.PlatformRegistry.applicationContext
import org.koin.dsl.module

actual fun createHttpClient(token: String): HttpClient {

    val context = applicationContext!!

    return HttpClient(OkHttp) {

        defaultRequest {
            url(BASE_URL)

            val token = getDauthToken(context)
            header("dauth", token)
        }

        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                }
            )
        }

        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }
}

private fun getDauthToken(context: Context): String {
    val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    return prefs.getString("dauth_token", "") ?: ""
}