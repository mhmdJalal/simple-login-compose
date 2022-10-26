package com.mhmdjalal.logincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.mhmdjalal.logincompose.navigation.LocalNavigationProvider
import com.mhmdjalal.logincompose.navigation.NavigationProvider
import com.mhmdjalal.logincompose.navigation.NavigationProviderImpl
import com.mhmdjalal.logincompose.ui.screens.MyAppNavHost
import com.mhmdjalal.logincompose.ui.theme.LoginComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}

@Composable
fun MainApp() {
    val navHostController = rememberNavController()
    val navigationProvider: NavigationProvider = remember {
        NavigationProviderImpl(navHostController)
    }
    CompositionLocalProvider(
        LocalNavigationProvider provides navigationProvider
    ) {
        LoginComposeTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                MyAppNavHost(navController = navHostController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginComposeTheme {
        MainApp()
    }
}