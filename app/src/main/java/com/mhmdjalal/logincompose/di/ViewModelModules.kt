package com.mhmdjalal.logincompose.di

import com.mhmdjalal.logincompose.ui.screens.auth.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

/**
 * @author Created by Muhamad Jalaludin on 25/10/22
 */

val viewModelModules = module {
    viewModelOf(::LoginViewModel)
}