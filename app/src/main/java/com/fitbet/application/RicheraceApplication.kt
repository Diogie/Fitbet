package com.fitbet.application

import android.app.Application
import com.fitbet.dagger.AppComponent
import com.fitbet.dagger.AppDatabaseModule
import com.fitbet.dagger.DaggerAppComponent

class RicheraceApplication : Application() {
    lateinit var mAppComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        mAppComponent = DaggerAppComponent.builder()
                .appDatabaseModule(AppDatabaseModule(applicationContext))
                .build()
        mAppComponent.inject(this)
    }
}