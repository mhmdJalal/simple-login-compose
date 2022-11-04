package com.mhmdjalal.logincompose.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mhmdjalal.logincompose.navigation.NavigationRoute
import com.mhmdjalal.logincompose.navigation.generateRouteWithJsonArg
import com.mhmdjalal.logincompose.navigation.routeArg
import com.mhmdjalal.logincompose.ui.screens.auth.LoginScreen
import com.mhmdjalal.logincompose.ui.screens.auth.LoginViewModel
import com.mhmdjalal.logincompose.ui.screens.home.HomeScreen
import org.koin.androidx.compose.koinViewModel

/**
 * @author Created by Muhamad Jalaludin on 25/10/22
 */
@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val routeLogin = NavigationRoute.routeLogin
    val routeMain = NavigationRoute.routeMain

    val viewModel = koinViewModel<LoginViewModel>()

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = routeLogin.routeArg
    ) {
        composable(routeLogin.routeArg) {
            LoginScreen(viewModel = viewModel)
        }
        composable(route = routeMain.routeArg, arguments = routeMain.namedNavArgs) {
            val token = routeMain.generateRouteWithJsonArg<String>(it.arguments)
            HomeScreen(viewModel, token = token)
        }
    }
}