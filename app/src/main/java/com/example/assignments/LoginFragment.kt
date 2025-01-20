package com.example.assignments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var credentialsManager: CredentialsManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        credentialsManager = CredentialsManager.getInstance()

        val rootView = inflater.inflate(R.layout.fragment_login, container, false)
        val edtEmail = rootView.findViewById<EditText>(R.id.edtEmail)
        val edtPassword = rootView.findViewById<EditText>(R.id.edtPassword)
        val btnLogin = rootView.findViewById<Button>(R.id.btnLogin)
        val tvRegister = rootView.findViewById<TextView>(R.id.tvRegister)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            if (credentialsManager.loginUser(email, password)) {
                Toast.makeText(requireContext(), "Login Successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
        }

        tvRegister.setOnClickListener {
            // Switch to RegisterFragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, RegisterFragment())
                .commit()
        }

        return rootView
    }
}
