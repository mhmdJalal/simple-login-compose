package com.mhmdjalal.logincompose.di

import com.mhmdjalal.logincompose.data.repository.LoginRepository
import com.mhmdjalal.logincompose.repo.LoginRepositoryImpl
import org.koin.core.module.dsl.bind
import com.mhmdjalal.logincompose.repo.network.LoginApi
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * @author Created by Muhamad Jalaludin on 25/10/22
 */

val repositoryModules = module {
    singleOf(::LoginApi)
    singleOf(::LoginRepositoryImpl) { bind<LoginRepository>() }
}