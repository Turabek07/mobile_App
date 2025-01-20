import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assignments.R
import com.example.assignments.CredentialsManager  // Import the CredentialsManager class

class LoginActivity : AppCompatActivity() {
    private val credentialsManager = CredentialsManager()  // Initialize CredentialsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailField = findViewById<EditText>(R.id.email)
        val passwordField = findViewById<EditText>(R.id.password)
        val nextButton = findViewById<Button>(R.id.Next_but)
        val rememberMeCheckbox = findViewById<CheckBox>(R.id.tRememberMe)

        nextButton.setOnClickListener {
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()

            if (email.isEmpty()) {
                emailField.error = "Email is required"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                passwordField.error = "Password is required"
                return@setOnClickListener
            }

            if (password.length < 6) {
                passwordField.error = "Password must be at least 6 characters"
                return@setOnClickListener
            }

            val rememberMe = rememberMeCheckbox.isChecked

            Toast.makeText(this, "Signed in", Toast.LENGTH_SHORT).show()
        }
        val lg = findViewById<View>(R.id.tRegisterNow)
        lg.setOnClickListener {
            val goToReg = Intent(this, RegisterActivity::class.java)
            startActivity(goToReg)
        }
    }
}
