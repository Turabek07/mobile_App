import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assignments.R
import com.google.android.material.textfield.TextInputLayout
import com.example.assignments.CredentialsManager
import com.example.assignments.MainActivity



class LoginActivity : AppCompatActivity() {

    private lateinit var credentialsManager: CredentialsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        credentialsManager = CredentialsManager()

        val emailField = findViewById<EditText>(R.id.email)
        val passwordField = findViewById<EditText>(R.id.password)
        val nextButton = findViewById<Button>(R.id.Next_but)
        val rememberMeCheckbox = findViewById<CheckBox>(R.id.tRememberMe)

        // Error handling views
        val emailInputLayout = findViewById<TextInputLayout>(R.id.emailInputLayout)
        val passwordInputLayout = findViewById<TextInputLayout>(R.id.passwordInputLayout)

        nextButton.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            // Reset error messages
            emailInputLayout.error = null
            passwordInputLayout.error = null

            // Validate email
            if (!credentialsManager.isEmailValid(email)) {
                emailInputLayout.error = "Invalid email"
                return@setOnClickListener
            }

            // Validate password
            if (!credentialsManager.isPasswordValid(password)) {
                passwordInputLayout.error = "Password is required"
                return@setOnClickListener
            }

            if (password.length < 6) {
                passwordInputLayout.error = "Password must be at least 6 characters"
                return@setOnClickListener
            }

            // Hardcoded credentials check
            if (email == "test@te.st" && password == "1234") {
                // Inform the user that they are signed in
                Toast.makeText(this, "Signed in", Toast.LENGTH_SHORT).show()

                // Navigate to MainActivity
                val goToMain = Intent(this, MainActivity::class.java)
                startActivity(goToMain)
                finish() // Optional: to prevent returning to the login activity
            } else {
                Toast.makeText(this, "Incorrect email or password", Toast.LENGTH_SHORT).show()
            }
        }

        // Register now click event to go to RegisterActivity
        val lg = findViewById<View>(R.id.tRegisterNow)
        lg.setOnClickListener {
            val goToReg = Intent(this, RegisterActivity::class.java)
            startActivity(goToReg)
        }
    }
}
