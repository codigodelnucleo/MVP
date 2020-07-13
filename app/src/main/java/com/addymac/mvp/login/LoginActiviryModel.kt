package com.addymac.mvp.login

import com.addymac.mvp.models.User
import javax.inject.Inject

class LoginActiviryModel @Inject constructor(private var  repository : LoginRepository)  : LoginActivityMVP.Model{


    override fun createUSer(firtsName: String, lasteName: String) {
        var user = User(firtsName,lasteName)
        repository.saveUser(user)
        }

    override fun getUser(): User {
       return repository.getUser()
    }

}