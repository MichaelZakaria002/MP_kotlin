package com.example.mp_assignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    // Declare the views
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signInButton: Button
    private lateinit var signUpButton: Button  // Declare sign-up button

    // Firebase Authentication instance
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Initialize views
        usernameEditText = findViewById(R.id.username)
        passwordEditText = findViewById(R.id.password)
        signInButton = findViewById(R.id.btn_sign_in)
        signUpButton = findViewById(R.id.btn_sign_up)  // Initialize the sign-up button

        // Handle Sign-In button click
        signInButton.setOnClickListener {
            val usernameOrEmail = usernameEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (usernameOrEmail.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both username/email and password", Toast.LENGTH_SHORT).show()
            } else {
                signInUser(usernameOrEmail, password)
            }
        }

        // Handle Sign-Up button click to navigate to SignUpActivity
        signUpButton.setOnClickListener {
            val intent = Intent(this@MainActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun signInUser(usernameOrEmail: String, password: String) {
        auth.signInWithEmailAndPassword(usernameOrEmail, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // If sign-in is successful, navigate to Home Page or MainActivity
                    val intent = Intent(this, MainActivity::class.java) // Or any other activity you prefer
                    startActivity(intent)
                    finish()  // Close the SignInActivity
                } else {
                    // If sign-in fails, show the error message
                    Toast.makeText(this, "Authentication failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
