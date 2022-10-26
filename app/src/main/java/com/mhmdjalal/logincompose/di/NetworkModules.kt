package com.mhmdjalal.logincompose.di

import android.util.Log
import com.mhmdjalal.logincompose.BuildConfig
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.observer.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * @author Created by Muhamad Jalaludin on 25/10/22
 */

val networkModules = module {
    singleOf(::ktorHttpClient)
}

private const val TIME_OUT = 60000

private val ktorHttpClient = HttpClient(Android) {
    // only accept success response and throw exceptions if failed
    expectSuccess = true

    // setup default request
    defaultRequest {
        host = BuildConfig.BASE_URL
        headers {
            append(HttpHeaders.ContentType, ContentType.Application.Json)
        }
        url {
            protocol = URLProtocol.HTTPS
        }
    }
    engine {
        // setup connect time out and socket time out
        connectTimeout = TIME_OUT
        socketTimeout = TIME_OUT
    }

    // json serialization
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }

    // logging
    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                Log.v("Logger Ktor =>", message)
            }

        }
        level = LogLevel.ALL
    }

    install(ResponseObserver) {
        onResponse { response ->
            Log.d("HTTP status:", "${response.status.value}")
        }
    }
}