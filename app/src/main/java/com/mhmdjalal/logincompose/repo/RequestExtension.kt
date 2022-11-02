package com.mhmdjalal.logincompose.repo

import com.mhmdjalal.logincompose.util.ErrorUtils.getErrorMessage
import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONObject
import java.net.SocketTimeoutException

enum class ResourceState {
    SUCCESS,
    ERROR,
    LOADING
}

data class Resource<out T>(val state: ResourceState, val data: T?, val message: String?, val showLoading: Boolean?) {

    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(ResourceState.SUCCESS, data, null, null)
        }

        fun <T> error(msg: String?, data: T? = null): Resource<T> {
            return Resource(ResourceState.ERROR, data, msg, null)
        }

        fun <T> loading(showLoading: Boolean): Resource<T> {
            return Resource(ResourceState.LOADING, null, null, showLoading)
        }

    }

}

suspend inline fun <reified T> request(crossinline response: suspend () -> HttpResponse): Flow<Resource<T>> = flow {
    try {
        emit(Resource.loading(showLoading = true))
        handlingResponse<T>(response)
            .collect { emit(it) }
    } catch (exception: Exception) {
        exception.printStackTrace()
        val messageError = exception.getErrorMessage()
        emit(Resource.error(messageError))
    } finally {
        emit(Resource.loading(showLoading = false))
    }
}

suspend inline fun <reified T> handlingResponse(crossinline response: suspend () -> HttpResponse): Flow<Resource<T>> = flow {
    var messageError: String? = null
    try {
        val result = response()

        if (result.status.value in 200..299) {
            // handle success response
            result.body<T>()?.let { body ->
                emit(Resource.success(body))
            }
        } else {
            try {
                val errBody = result.bodyAsText()
                val resError = JSONObject(errBody)
                if (resError.has("message")) {
                    messageError = resError.getString("message")
                }

                if (resError.has("error")) {
                    messageError = resError.getString("error")
                }

                if (resError.has("meta")) {
                    val metaError = JSONObject(resError.getString("meta"))
                    messageError = metaError.getString("message")
                }
            }  catch (e: SocketTimeoutException) {
                messageError = "Waktu koneksi habis"
            } catch (exception: Exception) {
                exception.printStackTrace()
                messageError = exception.getErrorMessage()
            }
        }
    } catch (e: SocketTimeoutException) {
        messageError = "Waktu koneksi habis"
    } catch (exception: Exception) {
        exception.printStackTrace()
        messageError = exception.getErrorMessage()
    } finally {
        if (messageError != null) emit(Resource.error(messageError))
    }
}