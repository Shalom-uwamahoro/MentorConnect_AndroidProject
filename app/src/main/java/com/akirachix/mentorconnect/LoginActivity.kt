package com.akirachix.mentorconnect

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.akirachix.mentorconnect.databinding.ActivityLoginBinding
import com.akirachix.mentorconnect.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater) //the inflate layout it is used to initiate the binding view

        setContentView(binding.root)

       binding.tvLogin.setOnClickListener{
           finish()
//            startActivity(Intent(this,MainActivity::class.java))  //you can just finish instead of creating another intent, bc login from login

       // Another way to connect other than binding method
//        setContentView(R.layout.activity_login)
//
//        val connectLogin = findViewById<TextView>(R.id.tvLogin)
//        connectLogin.setOnClickListener{
//            val intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)


    }
    binding.btnLogin.setOnClickListener {
        validateLogin()
    }

}

fun validateLogin() {

    clearErrors()
    var formError = false

    val userName2 = binding.etUsername2.text.toString()
    if (userName2.isBlank()) {
        formError = true
        binding.tilUsername2.error = "username is required"
    }

    val password2 = binding.etPassword2.text.toString()
    if (password2.isBlank()) {
        formError = true
        binding.tilPassword2.error = "password is required"
    }
    if (!formError) {
        //
    }
}
fun clearErrors() {
    binding.tilUsername2.error = null
    binding.tilPassword2.error = null


}
}

