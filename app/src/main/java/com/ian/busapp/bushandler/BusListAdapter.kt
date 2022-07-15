package com.ian.busapp.bushandler

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ian.busapp.R
import com.ian.busapp.bushandler.busview.BusDetails
import com.ian.busapp.studenthandler.uitel.loadImage
import com.ian.busapp.studenthandler.views.StudentDetails

class BusListAdapter(var mContext: Context, var teacherList:List<BusDataClass>):
    RecyclerView.Adapter<BusListAdapter.ListViewHolder>()
{
    inner class ListViewHolder(var v: View): RecyclerView.ViewHolder(v){
        var imgT = v.findViewById<ImageView>(R.id.busImageView)
        var busregT = v.findViewById<TextView>(R.id.busregTv)
        var buscolorT = v.findViewById<TextView>(R.id.buscolorTv)
        var busdriverT = v.findViewById<TextView>(R.id.busdriverTv)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        var infalter = LayoutInflater.from(parent.context)
        var v = infalter.inflate(R.layout.bus_row,parent,false)
        return ListViewHolder(v)
    }

    override fun getItemCount(): Int =teacherList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var newList = teacherList[position]
        holder.busregT.text = newList.busreg
        holder.buscolorT.text = newList.buscolor
        holder.busdriverT.text = newList.busdriver



        holder.imgT.loadImage(newList.imageUrl)
        holder.v.setOnClickListener {

            val busplate = newList.busreg
            val color = newList.buscolor
            val driver = newList.busdriver


            val imgUri = newList.imageUrl

            val mIntent = Intent(mContext, BusDetails::class.java)
            mIntent.putExtra("NAMET",busplate)
            mIntent.putExtra("COLOR",color)
            mIntent.putExtra("DRIVER",driver)


            mIntent.putExtra("IMGURI",imgUri)
            mContext.startActivity(mIntent)
        }
    }


}