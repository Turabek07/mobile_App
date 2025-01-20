package com.example.assignments

class CredentialsManager {

    private val userCredentials: MutableMap<String, String> = mutableMapOf()

    companion object {
        @Volatile
        private var INSTANCE: CredentialsManager? = null

        fun getInstance(): CredentialsManager =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: CredentialsManager().also { INSTANCE = it }
            }
    }


    fun loginUser(email: String, password: String): Boolean {
        return userCredentials[email.lowercase()] == password
    }


    fun registerUser(email: String, password: String): Boolean {
        if (userCredentials.containsKey(email.lowercase())) {
            return false
        }
        userCredentials[email.lowercase()] = password
        return true
    }


    fun isEmailValid(email: String): Boolean {
        if (email.isEmpty()) return false
        val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$")
        return email.matches(emailRegex)
    }


    fun isPasswordValid(password: String): Boolean {
        return password.isNotEmpty()
    }
}
