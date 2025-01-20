package com.example.assignments

class CredentialsManager {


    private val userCredentials: MutableMap<String, String> = mutableMapOf()


    fun isEmailValid(email: String): Boolean {
        if (email.isEmpty()) return false
        val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$")
        return email.matches(emailRegex)
    }


    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }


    fun register(email: String, password: String): String {
        val emailLowerCase = email.trim().toLowerCase()


        if (userCredentials.containsKey(emailLowerCase)) {
            return "Email is already registered"
        }


        userCredentials[emailLowerCase] = password
        return "Registration successful"
    }
}


