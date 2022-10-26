package com.mhmdjalal.logincompose.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.mhmdjalal.logincompose.navigation.LocalNavigationProvider
import com.mhmdjalal.logincompose.ui.components.LayoutAppBar

/**
 * @author Created by Muhamad Jalaludin on 25/10/22
 */

@Composable
fun HomeScreen(token: String?) {
    val navigationProvider = LocalNavigationProvider.current

    LayoutAppBar(
        title = "Dashboard",
        onBack = { navigationProvider.back() }) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(text = "Token : $token")
        }
    }
}