package com.mhmdjalal.logincompose.data.dto

import kotlinx.serialization.Serializable

/**
 * @author Created by Muhamad Jalaludin on 26/10/22
 */

@Serializable
data class LoginDto(
    val email: String?,
    val password: String?
)
