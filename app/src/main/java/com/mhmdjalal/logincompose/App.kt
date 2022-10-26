package com.mhmdjalal.logincompose

import android.app.Application
import com.mhmdjalal.logincompose.di.networkModules
import com.mhmdjalal.logincompose.di.repositoryModules
import com.mhmdjalal.logincompose.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @author Created by Muhamad Jalaludin on 25/10/22
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(
                networkModules,
                repositoryModules,
                viewModelModules
            ))
        }
    }

}