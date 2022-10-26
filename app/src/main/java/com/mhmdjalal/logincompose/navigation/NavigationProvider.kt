package com.mhmdjalal.logincompose.navigation

import androidx.compose.runtime.compositionLocalOf

interface NavigationProvider {
    fun back()
    fun navigateToMain(token: String?)
}

val LocalNavigationProvider =
    compositionLocalOf<NavigationProvider> { error("navigation") }