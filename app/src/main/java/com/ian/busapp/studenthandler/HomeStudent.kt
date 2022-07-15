package com.ian.busapp.studenthandler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ian.busapp.R
import com.ian.busapp.studenthandler.views.AddStudent
import com.ian.busapp.studenthandler.views.ViewStudent
import kotlinx.android.synthetic.main.activity_home_student.*

class HomeStudent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_student)
        btnViewAll.setOnClickListener {
            startActivity(Intent(this,ViewStudent::class.java))
        }
        btnAddInfo.setOnClickListener {
            startActivity(Intent(this,AddStudent::class.java))
        }
    }
}