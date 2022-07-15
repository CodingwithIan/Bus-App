package com.ian.busapp.bushandler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ian.busapp.R
import com.ian.busapp.bushandler.busview.AddBus
import com.ian.busapp.bushandler.busview.ViewBus
import com.ian.busapp.studenthandler.views.AddStudent
import com.ian.busapp.studenthandler.views.ViewStudent
import kotlinx.android.synthetic.main.activity_home_student.*

class BusHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_home)
        btnViewAll.setOnClickListener {
            startActivity(Intent(this, ViewBus::class.java))
        }
        btnAddInfo.setOnClickListener {
            startActivity(Intent(this, AddBus::class.java))
        }
    }
}