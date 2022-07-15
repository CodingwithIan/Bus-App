package com.ian.busapp.studenthandler.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ian.busapp.R
import com.ian.busapp.studenthandler.uitel.loadImage
import kotlinx.android.synthetic.main.activity_student_details.*

class StudentDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val intss = intent
        var nameT = intss.getStringExtra("NAMET")
        var imgT = intss.getStringExtra("IMGURI")
        var schoolT = intss.getStringExtra("A")
        var classT = intss.getStringExtra("B")
        var stationT = intss.getStringExtra("C")
        var mobileT = intss.getStringExtra("D")

        nameDetailTextView.text = nameT
        studentSchoolDetails.text = schoolT
        studentClassDetails.text = classT
        stationDetails.text = stationT
        contactDetails.text = mobileT

        teacherDetailImageView.loadImage(imgT)
    }
}