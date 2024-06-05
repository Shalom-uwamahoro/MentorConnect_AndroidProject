package com.akirachix.mentorconnect

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.akirachix.mentorconnect.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvRegister.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

//        val connectRegister = findViewById<TextView>(R.id.tvRegister)
//        connectRegister.setOnClickListener{
//            val intent = Intent(this,LoginActivity::class.java)
//            startActivity(intent)
        }
        binding.btnRegister.setOnClickListener {
            validateRegistration()
        }

    }

    fun validateRegistration() {
       clearErrors()
        var formError = false

        val firstName = binding.etFirstName.text.toString()
        if (firstName.isBlank()) {
            formError = true
            binding.tilFirstName.error = "First name is required"
        }

        val lastName = binding.etLastName.text.toString()
        if (lastName.isBlank()) {
            formError = true
            binding.tilLastName.error = "Last name is required"
        }

        val email = binding.etEmail.text.toString()
        if (email.isBlank()) {
            formError = true
            binding.tilEmail.error = "email address is required"
        }

        val codeHiveId = binding.etId.text.toString()
        if (codeHiveId.isBlank()) {
            formError = true
            binding.tilId.error = "CodeHive id  is required"
        }

        val userName = binding.etUsername.text.toString()
        if (userName.isBlank()) {
            formError = true
            binding.tilUsername.error = "email address is required"
        }

        val password = binding.etPassword.text.toString()
        if (password.isBlank()) {
            formError = true
            binding.tilPassword.error =
                getString(R.string.password_is_required)  // we had this "Password is required" then we extracted it so as to avoid hard coding
        }

        val passwordConf = binding.etConfirmPassword.text.toString()
        if (passwordConf.isBlank()) {
            formError = true
            binding.tilConfirmPassword.error = getString(R.string.password_confirmation_is_required)
        }
        if (password != passwordConf) {
            formError = true
            binding.tilConfirmPassword.error =
                getString(R.string.password_and_confirmation_do_not_match)  // we had a normal text then, click on it and extract from the yellow bulb
            // bcs we are not supposed to hard code the string
        }
        if (!formError) {
            // proceed to register, this could be done if our register button was connected to an Activity(web page in Kotlin)
        }
    }

        fun clearErrors() {
            binding.tilFirstName.error = null
            binding.tilLastName.error = null
            binding.tilEmail.error = null
            binding.tilId.error = null
            binding.tilUsername.error = null
            binding.tilPassword.error = null
            binding.tilConfirmPassword.error = null


        }
    }

