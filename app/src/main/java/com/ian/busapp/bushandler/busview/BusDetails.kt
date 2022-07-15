package com.ian.busapp.bushandler.busview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ian.busapp.R
import com.ian.busapp.studenthandler.uitel.loadImage
import kotlinx.android.synthetic.main.activity_bus_details.*
import kotlinx.android.synthetic.main.activity_student_details.*

class BusDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_details)

        val intss = intent
        var imgT = intss.getStringExtra("IMGURI")
        var busregT = intss.getStringExtra("NAMET")
        var buscolorT = intss.getStringExtra("COLOR")
        var busdriverT = intss.getStringExtra("DRIVER")


        busnumberplate.text = busregT
        buscolor.text = buscolorT
        busdriver.text = busdriverT

        busImage.loadImage(imgT)
    }
}