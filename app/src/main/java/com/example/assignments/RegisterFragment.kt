package com.example.assignments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var credentialsManager: CredentialsManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        credentialsManager = CredentialsManager.getInstance()

        val rootView = inflater.inflate(R.layout.fragment_register, container, false)
        val edtEmail = rootView.findViewById<EditText>(R.id.edtEmail)
        val edtPassword = rootView.findViewById<EditText>(R.id.edtPassword)
        val btnRegister = rootView.findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            if (credentialsManager.registerUser(email, password)) {
                Toast.makeText(context, "Registration Successful", Toast.LENGTH_SHORT).show()
                // Switch back to LoginFragment
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, LoginFragment())
                    .commit()
            } else {
                Toast.makeText(context, "Email already taken", Toast.LENGTH_SHORT).show()
            }
        }

        return rootView
    }
}


