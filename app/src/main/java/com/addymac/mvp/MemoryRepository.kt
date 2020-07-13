package com.addymac.mvp

import com.addymac.mvp.login.LoginRepository
import com.addymac.mvp.models.User

class MemoryRepository  : LoginRepository{

    private lateinit var user : User
    override fun saveUser(user : User) {
        if(user == null){
            this.user = getUser()
        }else
        {
            this.user = user
        }
    }

    override fun getUser(): User {
        if(user == null){
            this.user = User("Antonio", "Balderas")
            return user
        }else
        {
            return user
        }
    }
}