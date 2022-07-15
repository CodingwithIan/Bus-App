package com.ian.busapp.drivershandler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ian.busapp.R
import com.ian.busapp.drivershandler.driverview.AddDriver
import com.ian.busapp.drivershandler.driverview.ViewDrivers
import kotlinx.android.synthetic.main.activity_home_student.*

class DriverHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_home)
        btnViewAll.setOnClickListener {
            startActivity(Intent(this, ViewDrivers::class.java))
        }
        btnAddInfo.setOnClickListener {
            startActivity(Intent(this, AddDriver::class.java))
        }
    }
}