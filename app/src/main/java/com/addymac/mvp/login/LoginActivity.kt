package com.addymac.mvp.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.addymac.mvp.App
import com.addymac.mvp.R
import com.addymac.mvp.models.Game
import com.addymac.mvp.models.Post
import com.addymac.mvp.models.Twich
import com.addymac.mvp.network.TwichAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LoginActivity : AppCompatActivity() , LoginActivityMVP.View{
    private lateinit var firstName : EditText
    private lateinit var lastName : EditText
    private lateinit var loginButton : Button

    @Inject
     lateinit var presenter : LoginActivityMVP.Presenter

    @Inject
     lateinit var postAPI : TwichAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).component.inject(this)


        firstName = findViewById(R.id.edit_text_first_name)
        lastName = findViewById(R.id.edit_text_last_name)
        loginButton = findViewById(R.id.button_login)

        loginButton.setOnClickListener {
            presenter.loginButtonClicked()
        }

        var call = postAPI.getAllPosts()
        call.enqueue( object : Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
               var post : List<Post>? = response.body()
                post?.forEach {
                    Log.d("*****" , it.title)
                }
               }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("****", t.stackTrace.toString())
            }
        })


    }

    override fun onResume() {
        super.onResume()
        presenter.setView(this)
       // presenter.getCurrentUser()
    }


    override fun getFirstName(): String {
        return  this.firstName.text.toString()
    }

    override fun getLastName(): String {
        return this.lastName.text.toString()
    }

    override fun showUserNotAvailable() {
        Toast.makeText(this, "Error el usuario no esta disponible", Toast.LENGTH_SHORT).show()
    }

    override fun showInputError() {
        Toast.makeText(this, "Error el nombre ni apellido pueden estar vacios", Toast.LENGTH_SHORT).show()
    }

    override fun showUserSaved() {
        Toast.makeText(this, "Usuario guardado correctamente", Toast.LENGTH_SHORT).show()
    }

    override fun setFirstName(firtsName: String) {
        this.firstName.setText( firtsName)
        }

    override fun setLastName(lasteName: String) {
        this.lastName.setText(lasteName)
    }
}
