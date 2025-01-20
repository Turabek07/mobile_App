import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assignments.CredentialsManager
import com.example.assignments.R

class RegisterActivity : AppCompatActivity() {

    private val credentialsManager = CredentialsManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val fullNameEditText = findViewById<EditText>(R.id.tName)
        val validEmailEditText = findViewById<EditText>(R.id.tEmail)
        val phoneNumberEditText = findViewById<EditText>(R.id.tPhoneNumber)
        val strongPasswordEditText = findViewById<EditText>(R.id.tPassword)
        val termsAndConditionsCheckBox = findViewById<CheckBox>(R.id.agreementCheck)
        val nextButton = findViewById<Button>(R.id.nextButton)

        nextButton.setOnClickListener {

            val fullName = fullNameEditText.text.toString()
            val validEmail = validEmailEditText.text.toString()
            val phoneNumber = phoneNumberEditText.text.toString()
            val strongPassword = strongPasswordEditText.text.toString()
            val isTermsAccepted = termsAndConditionsCheckBox.isChecked

            if (isTermsAccepted) {
                if (!credentialsManager.isEmailValid(validEmail)) {
                    validEmailEditText.error = "Invalid email format"
                    return@setOnClickListener
                }

                if (!credentialsManager.isPasswordValid(strongPassword)) {
                    strongPasswordEditText.error = "Password cannot be empty"
                    return@setOnClickListener
                }

                val registrationResult = credentialsManager.register(validEmail, strongPassword)
                if (registrationResult == "Registration successful") {
                    Toast.makeText(this, "You have successfully registered!", Toast.LENGTH_SHORT).show()

                    // Redirect to LoginActivity after successful registration
                    val goToLogin = Intent(this, LoginActivity::class.java)
                    startActivity(goToLogin)
                    finish() // Optional, to close the current activity
                } else {
                    Toast.makeText(this, registrationResult, Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please accept the Terms and Conditions", Toast.LENGTH_SHORT).show()
            }
        }

        val lg = findViewById<View>(R.id.register)
        lg.setOnClickListener {
            val goToReg = Intent(this, LoginActivity::class.java)
            startActivity(goToReg)
        }
    }
}
