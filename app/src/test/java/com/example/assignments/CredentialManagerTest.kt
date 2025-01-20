package com.example.assignments


import org.junit.Test
import org.junit.Assert.*

class CredentialsManagerTest {

    private val credentialsManager = CredentialsManager()


    @Test
    fun givenEmptyEmail_thenReturnFalse() {
        assertEquals(false, credentialsManager.isEmailValid(""))
    }


    @Test
    fun givenWrongEmailFormat_thenReturnFalse() {
        assertEquals(false, credentialsManager.isEmailValid("mynamegmail.com"))
        assertEquals(false, credentialsManager.isEmailValid("mynamegmail.@com"))
        assertEquals(false, credentialsManager.isEmailValid("mynamegmail.com@"))
    }


    @Test
    fun givenValidEmail_thenReturnTrue() {
        assertEquals(true, credentialsManager.isEmailValid("myname@gmail.com"))
    }


    @Test
    fun givenEmptyPassword_thenReturnFalse() {
        assertEquals(false, credentialsManager.isPasswordValid(""))
    }


    @Test
    fun givenNonEmptyPassword_thenReturnTrue() {
        assertEquals(true, credentialsManager.isPasswordValid("password123"))
    }
}
