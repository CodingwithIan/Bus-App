package com.ian.busapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.ian.busapp.auth.LoginActivity
import com.ian.busapp.bushandler.BusHome
import com.ian.busapp.databinding.ActivityDashboardBinding
import com.ian.busapp.drivershandler.DriverHome
import com.ian.busapp.studenthandler.HomeStudent
import com.ian.busapp.transactions.MainHolder

class Dashboard : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private lateinit var user: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        user= FirebaseAuth.getInstance()

        binding.logout.setOnClickListener {
            user.signOut()

            startActivity(Intent(this,LoginActivity::class.java))
        }
        binding.pendingbills.setOnClickListener {
            startActivity(Intent(this,MainHolder::class.java))
        }
        binding.mystudents.setOnClickListener {
            startActivity(Intent(this,HomeStudent::class.java))
        }
        binding.mybus.setOnClickListener {
            startActivity(Intent(this,BusHome::class.java))
        }
        binding.mydrivers.setOnClickListener {
            startActivity(Intent(this,DriverHome::class.java))
        }


    }

    override fun onSupportNavigateUp(): Boolean {
       onBackPressed()
        return true
    }
}