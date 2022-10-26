package com.mhmdjalal.logincompose.navigation

import androidx.navigation.NavHostController

class NavigationProviderImpl(
    private val navHostController: NavHostController
) : NavigationProvider {
    override fun back() {
        navHostController.popBackStack()
    }

    override fun navigateToMain(token: String?) {
        val route = NavigationRoute.routeMain
        navigate(route, token)
    }

    private fun navigate(route: NavigationRoute) {
        navHostController.navigate(route.route)
    }

    private inline fun<reified T> navigate(route: NavigationRoute, data: T) {
        val routeArg = route.generateRouteWithDataArg(data)
        navHostController.navigate(routeArg)
    }
}