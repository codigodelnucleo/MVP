package com.addymac.mvp.login

import com.addymac.mvp.models.User
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.*


class LoginActivityPresenterTest {

    lateinit var presenter : LoginActivityPresenter
    lateinit var user : User

    lateinit var mockedView : LoginActivityMVP.View
    lateinit var mockedModel : LoginActivityMVP.Model


    @Before
    fun setUp() {
        mockedModel = mock(LoginActivityMVP.Model::class.java)
        mockedView = mock(LoginActivityMVP.View::class.java)

        user = User("Miriam","Terrazas")
        //`when`(mockedModel.getUser()).thenReturn(user)
        //`when`(mockedView.getFirstName()).thenReturn("Miriam")
        //`when`(mockedView.getLastName()).thenReturn("Terrazas")

        presenter =   LoginActivityPresenter(mockedModel)
        presenter.setView(mockedView)

    }

    @Test
    fun notExistInteractionWithView() {
        presenter.getCurrentUser()
        verify(mockedView, times(1)).showUserNotAvailable()
        //verifyZeroInteractions(mockedView)
    }

    @Test
    fun loadUserFromRepoWhenValidUserIsPresent(){
        `when`(mockedModel.getUser()).thenReturn(user)
        presenter.getCurrentUser()
        verify(mockedView, times(1)).showUserNotAvailable()
    }

    @After
    fun tearDown() {

    }
}