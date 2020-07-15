package com.addymac.mvp.di

import com.addymac.mvp.login.LoginActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, LoginModule::class, NetworkModule::class])
interface AppComponent {
    fun inject (mainActivity : LoginActivity)
}