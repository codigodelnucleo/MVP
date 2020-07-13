package com.addymac.mvp

import android.app.Application
import com.addymac.mvp.di.AppComponent
import com.addymac.mvp.di.ApplicationModule
import com.addymac.mvp.di.DaggerAppComponent
import com.addymac.mvp.di.LoginModule

class App : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
            component = initDagger(this)
    }

   private fun initDagger(app : App): AppComponent{
        return DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(app))
            .loginModule(LoginModule())
            .build()
    }

}