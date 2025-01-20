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

    // Test for password validation
    @Test
    fun givenEmptyPassword_thenReturnFalse() {
        assertEquals(false, credentialsManager.isPasswordValid(""))
    }

    @Test
    fun givenNonEmptyPassword_thenReturnTrue() {
        assertEquals(true, credentialsManager.isPasswordValid("password123"))
    }

    // Test for the registration functionality
    @Test
    fun testRegisterNewAccount() {
        val result = credentialsManager.register("test@te.st", "1234")
        assertEquals("Registration successful", result)
    }

    @Test
    fun testRegisterDuplicateEmail() {
        credentialsManager.register("test@te.st", "1234")
        val result = credentialsManager.register("test@te.st", "5678")
        assertEquals("Email is already registered", result)
    }

    @Test
    fun testRegisterEmailCaseInsensitivity() {
        credentialsManager.register("test@te.st", "1234")
        val result = credentialsManager.register("TEST@TE.ST", "5678")
        assertEquals("Email is already registered", result)
    }
}
