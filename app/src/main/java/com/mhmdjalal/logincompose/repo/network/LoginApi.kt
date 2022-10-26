package com.mhmdjalal.logincompose.repo.network

import com.mhmdjalal.logincompose.data.dto.LoginDto
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * @author Created by Muhamad Jalaludin on 26/10/22
 */
class LoginApi(private val client: HttpClient) {

    suspend fun login(request: LoginDto) = client.post("/api/login") {
        setBody(request)
    }

}