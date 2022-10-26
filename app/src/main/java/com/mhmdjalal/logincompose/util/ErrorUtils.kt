package com.mhmdjalal.logincompose.util

import io.ktor.client.plugins.*
import io.ktor.http.*
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object ErrorUtils {
    fun Exception.getErrorMessage(): String = when (this) {
        is ServerResponseException -> this.response.status.description
        is ClientRequestException -> {
            when (this.response.status) {
                HttpStatusCode.BadRequest -> "Invalid data"
                HttpStatusCode.Unauthorized -> "Unable to access data"
                HttpStatusCode.Forbidden -> "Session has ended"
                HttpStatusCode.NotFound -> "Data not found"
                else -> this.response.status.description
            }
        }
        is UnknownHostException -> "Unknown Error"
        is ConnectException -> "No internet connected"
        is SocketTimeoutException -> "No internet connected"
        else ->  "Oops, An error occurred, please try again in a moment"
    }
}