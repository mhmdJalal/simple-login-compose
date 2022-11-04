package com.mhmdjalal.logincompose.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mhmdjalal.logincompose.navigation.LocalNavigationProvider
import com.mhmdjalal.logincompose.ui.components.LayoutAppBar
import com.mhmdjalal.logincompose.ui.screens.auth.LoginViewModel
import org.koin.androidx.compose.koinViewModel

/**
 * @author Created by Muhamad Jalaludin on 25/10/22
 */

@Composable
fun HomeScreen(
    viewModel: LoginViewModel = koinViewModel(),
    token: String?
) {
    val navigationProvider = LocalNavigationProvider.current

    LayoutAppBar(
        title = "Dashboard",
        onBack = {
            viewModel.setDefault()
            navigationProvider.back()
        }
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "Token : $token")
        }
    }
}