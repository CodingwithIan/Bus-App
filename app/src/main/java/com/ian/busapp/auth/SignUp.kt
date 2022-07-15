package com.ian.busapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.ian.busapp.Dashboard
import com.ian.busapp.R
import com.ian.busapp.databinding.ActivitySignUpBinding
import com.ian.busapp.transactions.MainHolder

class SignUp : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth= FirebaseAuth.getInstance()

        binding.login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.registerBtn.setOnClickListener {
            val jina=binding.companyName.text.toString()
            val arafa=binding.companyEmail.text.toString().trim { it <= ' ' }
            val simu=binding.companyPhone.text.toString()
            val siri=binding.companyPasscode.text.toString()

            if (jina.isEmpty()&&arafa.isEmpty()&&simu.isEmpty()&&siri.isEmpty()){
                Toast.makeText(this,"Fill in details", Toast.LENGTH_LONG).show()
            }
            else{

                auth.createUserWithEmailAndPassword(arafa,siri).addOnCompleteListener {
                    if (it.isSuccessful){
                        startActivity(Intent(this, UserProfile::class.java))
                        Toast.makeText(this,"Success $jina", Toast.LENGTH_LONG).show()
                    }
                    else{
                        Toast.makeText(this,it.exception.toString(), Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    }
