package com.mhmdjalal.logincompose.data.repository

import com.mhmdjalal.logincompose.data.dto.LoginDto
import com.mhmdjalal.logincompose.data.models.LoginResponse
import com.mhmdjalal.logincompose.repo.Resource
import kotlinx.coroutines.flow.Flow

/**
 * @author Created by Muhamad Jalaludin on 26/10/22
 */
interface LoginRepository {
    suspend fun login(request: LoginDto): Flow<Resource<LoginResponse>>
}