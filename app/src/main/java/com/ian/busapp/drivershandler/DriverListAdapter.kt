package com.ian.busapp.drivershandler

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ian.busapp.R
import com.ian.busapp.drivershandler.driverview.DriverDetails
import com.ian.busapp.studenthandler.uitel.loadImage


class DriverListAdapter(var mContext: Context, var teacherList:List<Driver>):
    RecyclerView.Adapter<DriverListAdapter.ListViewHolder>()
{
    inner class ListViewHolder(var v: View): RecyclerView.ViewHolder(v){
        var imgT = v.findViewById<ImageView>(R.id.driverImageView)
        var drivernameT = v.findViewById<TextView>(R.id.driverNameTv)
        var driverIdT = v.findViewById<TextView>(R.id.driverIdTv)
        var driverContactT = v.findViewById<TextView>(R.id.driverContacttv)
        var drivervehicleT = v.findViewById<TextView>(R.id.driverVehicleTv)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        var infalter = LayoutInflater.from(parent.context)
        var v = infalter.inflate(R.layout.driver_row,parent,false)
        return ListViewHolder(v)
    }

    override fun getItemCount(): Int =teacherList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var newList = teacherList[position]
        holder.drivernameT.text = newList.driverName
        holder.driverContactT.text = newList.driverMobile
        holder.driverIdT.text = newList.driverId
        holder.drivervehicleT.text = newList.driverVehicle



        holder.imgT.loadImage(newList.imageUrl)
        holder.v.setOnClickListener {

            val name = newList.driverName
            val id = newList.driverId
            val namba = newList.driverMobile
            val gari = newList.driverVehicle



            val imgUri = newList.imageUrl

            val mIntent = Intent(mContext, DriverDetails::class.java)
            mIntent.putExtra("NAMET",name)
            mIntent.putExtra("A",id)
            mIntent.putExtra("B",namba)
            mIntent.putExtra("C",gari)


            mIntent.putExtra("IMGURI",imgUri)
            mContext.startActivity(mIntent)
        }
    }


}