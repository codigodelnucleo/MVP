package com.addymac.mvp.login

import com.addymac.mvp.models.User

interface LoginRepository  {
    fun saveUser(user : User)
    fun getUser(): User
}