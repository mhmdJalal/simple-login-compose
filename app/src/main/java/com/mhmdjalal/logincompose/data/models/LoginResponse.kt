package com.mhmdjalal.logincompose.data.models

import kotlinx.serialization.Serializable

/**
 * @author Created by Muhamad Jalaludin on 26/10/22
 */

@Serializable
data class LoginResponse(
    val token: String? = null,
    val error: String? = null
)
