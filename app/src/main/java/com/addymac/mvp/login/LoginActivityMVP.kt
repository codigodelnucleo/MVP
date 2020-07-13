package com.addymac.mvp.login

import com.addymac.mvp.models.User

interface LoginActivityMVP {


    interface View {
        fun getFirstName() : String
        fun getLastName() : String

        fun showUserNotAvailable()
        fun showInputError()
        fun showUserSaved()

        fun setFirstName (firtsName : String)
        fun setLastName (lasteName : String)
    }

    interface Presenter{
        fun setView(view : LoginActivityMVP.View)
        fun loginButtonClicked()
        fun getCurrentUser()

    }

    interface Model{
        fun createUSer(firtsName: String, lasteName: String)
        fun getUser() : User

    }

}