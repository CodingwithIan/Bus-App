package com.ian.busapp.studenthandler

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ian.busapp.R
import com.ian.busapp.studenthandler.uitel.loadImage
import com.ian.busapp.studenthandler.views.StudentDetails

class ListAdapter(var mContext:Context,var teacherList:List<Students>):
    RecyclerView.Adapter<ListAdapter.ListViewHolder>()
{
    inner class ListViewHolder(var v:View): RecyclerView.ViewHolder(v){
        var imgT = v.findViewById<ImageView>(R.id.teacherImageView)
        var nameT = v.findViewById<TextView>(R.id.studentNameTv)
        var schoolT = v.findViewById<TextView>(R.id.studentSchoolTv)
        var classT = v.findViewById<TextView>(R.id.studentClassTv)
        var stationT = v.findViewById<TextView>(R.id.stationTv)
        var mobileT = v.findViewById<TextView>(R.id.guardianContactTv)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        var infalter = LayoutInflater.from(parent.context)
        var v = infalter.inflate(R.layout.student_row,parent,false)
        return ListViewHolder(v)
    }

    override fun getItemCount(): Int =teacherList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var newList = teacherList[position]
        holder.nameT.text = newList.name
        holder.schoolT.text = newList.school
        holder.classT.text = newList.clas
        holder.stationT.text = newList.station
        holder.mobileT.text = newList.mobile


        holder.imgT.loadImage(newList.imageUrl)
        holder.v.setOnClickListener {

            val name = newList.name
            val shule = newList.school
            val darasa = newList.clas
            val chuk = newList.station
            val simu = newList.mobile


            val imgUri = newList.imageUrl

            val mIntent = Intent(mContext,StudentDetails::class.java)
            mIntent.putExtra("NAMET",name)
            mIntent.putExtra("A",shule)
            mIntent.putExtra("B",darasa)
            mIntent.putExtra("C",chuk)
            mIntent.putExtra("D",simu)

            mIntent.putExtra("IMGURI",imgUri)
            mContext.startActivity(mIntent)
        }
    }


}