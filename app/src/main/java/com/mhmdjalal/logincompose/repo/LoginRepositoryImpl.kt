package com.mhmdjalal.logincompose.repo

import com.mhmdjalal.logincompose.data.dto.LoginDto
import com.mhmdjalal.logincompose.data.models.LoginResponse
import com.mhmdjalal.logincompose.data.repository.LoginRepository
import com.mhmdjalal.logincompose.repo.network.LoginApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @author Created by Muhamad Jalaludin on 26/10/22
 */
class LoginRepositoryImpl(private val loginApi: LoginApi): LoginRepository {

    override suspend fun login(request: LoginDto): Flow<Resource<LoginResponse>> = flow {
        request<LoginResponse> { loginApi.login(request) }
            .collect {
                emit(it)
            }
    }
}