package com.ian.busapp.drivershandler.driverview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ian.busapp.R
import com.ian.busapp.studenthandler.uitel.loadImage
import kotlinx.android.synthetic.main.activity_driver_details.*
import kotlinx.android.synthetic.main.activity_student_details.*

class DriverDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_details)
        val intss = intent
        var nameT = intss.getStringExtra("NAMET")
        var imgT = intss.getStringExtra("IMGURI")
        var idT = intss.getStringExtra("A")
        var contactT = intss.getStringExtra("B")
        var vehicleT = intss.getStringExtra("C")


        driverName.text = nameT
        driverId.text = idT
        driverContact.text = contactT
        driverVehicle.text = vehicleT


        teacherDetailImageView.loadImage(imgT)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}