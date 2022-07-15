package com.ian.busapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.ian.busapp.Dashboard
import com.ian.busapp.databinding.ActivityLoginBinding
import com.ian.busapp.transactions.MainHolder

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth= FirebaseAuth.getInstance()

        checkIfUserLoggedIn()

//        binding.forgotPass.setOnClickListener {
//            startActivity(Intent(this, ResetPasswordActivity::class.java))
//        }
        binding.registerHere.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
        }
        binding.loginBtn.setOnClickListener {
            val arafa=binding.companyEmail.text.toString().trim { it <= ' ' }
            val siri=binding.companyPasscode.text.toString().trim { it <= ' ' }
            if (arafa.isEmpty()&&siri.isEmpty()){
                Toast.makeText(this,"Fill in your Details", Toast.LENGTH_LONG).show()
            }
            else{
                auth.signInWithEmailAndPassword(arafa,siri).addOnCompleteListener {
                    if (it.isSuccessful){
                        startActivity(Intent(this, Dashboard::class.java))

                    }
                    else{
                        Toast.makeText(this,it.exception.toString(), Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun checkIfUserLoggedIn() {
        if (auth.currentUser!=null){
            startActivity(Intent(this, Dashboard::class.java))
            finish()
        }

    }
}