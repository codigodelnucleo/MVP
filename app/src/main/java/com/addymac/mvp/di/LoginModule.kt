package com.addymac.mvp.di

import com.addymac.mvp.MemoryRepository
import com.addymac.mvp.login.LoginActiviryModel
import com.addymac.mvp.login.LoginActivityMVP
import com.addymac.mvp.login.LoginActivityPresenter
import com.addymac.mvp.login.LoginRepository
import dagger.Module
import dagger.Provides

@Module
class LoginModule {


    @Provides
    fun provideLoginActivityPresenter(model: LoginActivityMVP.Model): LoginActivityMVP.Presenter {
        return LoginActivityPresenter(model)
    }
    @Provides
    fun providesLoginActivityModel(repository: LoginRepository) : LoginActivityMVP.Model{
        return  LoginActiviryModel(repository)
    }

    @Provides
    fun provideRepository(): LoginRepository{
        return  MemoryRepository()
    }
}