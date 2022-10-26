package com.mhmdjalal.logincompose.ui.screens.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mhmdjalal.logincompose.data.dto.LoginDto
import com.mhmdjalal.logincompose.data.models.LoginResponse
import com.mhmdjalal.logincompose.data.repository.LoginRepository
import com.mhmdjalal.logincompose.repo.ResourceState.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * @author Created by Muhamad Jalaludin on 26/10/22
 */
class LoginViewModel(private val repo: LoginRepository): ViewModel() {

    val showLoading = mutableStateOf(value = false)

    private var _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage = _errorMessage.asStateFlow()

    private var _loginResult = MutableStateFlow<LoginResponse?>(null)
    val loginResult = _loginResult.asStateFlow()

    fun login(email: String?, password: String?) {
        viewModelScope.launch {
            repo.login(LoginDto(email, password))
                .collect { result ->
                    when (result.state) {
                        SUCCESS -> {
                            _loginResult.update { result.data }
                        }
                        ERROR -> {
                            _errorMessage.update { result.message }
                        }
                        LOADING -> {
                            showLoading.value = result.showLoading ?: false
                        }
                    }
                }
        }
    }

    fun setDefault() {
        showLoading.value = false
        _errorMessage.update { null }
        _loginResult.update { null }
    }

}