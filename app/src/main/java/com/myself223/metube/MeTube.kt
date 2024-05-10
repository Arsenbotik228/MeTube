package com.myself223.metube

import android.app.Application
import com.myself223.metube.di.repoModule
import com.myself223.metube.di.uiModule
import com.salievYT.metube.di.netModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MeTube:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MeTube)
            modules(netModule , repoModule , uiModule)
        }
    }
}