package com.addymac.mvp.login

import com.addymac.mvp.models.User
import javax.inject.Inject

class LoginActivityPresenter @Inject constructor(var model : LoginActivityMVP.Model) : LoginActivityMVP.Presenter{

   private lateinit var view : LoginActivityMVP.View
   //private  lateinit var  model : LoginActivityMVP.Model


    override fun setView(view: LoginActivityMVP.View) {
        this.view = view
    }

    override fun loginButtonClicked() {
        if(view != null){
            if(view.getFirstName().trim().equals("")|| view.getLastName().trim().equals("")){
                view.showInputError()
            }else{
                model.createUSer(view.getFirstName(),view.getLastName())
                view.showUserSaved()
            }
        }
    }

    override fun getCurrentUser() {
        var user =  model.getUser()
        if(user == null){
            if(view != null){
                view.showUserNotAvailable()
            }
        }else{
            if(view != null){
                view.setFirstName(user.firtsName)
                view.setLastName(user.lastName)
            }
        }
    }
}