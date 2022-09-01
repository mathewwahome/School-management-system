package com.example.school.basaa.viewdb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.school.R

class MyAdapter(private val userList: ArrayList<Fees>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.user_item,
        parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]

        holder.name.text = currentitem.stdname//should be the one in the database
        holder.adm.text = currentitem.adm
        holder.amount.text = currentitem.amount
        holder.balance.text = currentitem.totalfee
//        holder.method.text = currentitem.stowhen
        holder.date.text = currentitem.date

    }

    override fun getItemCount(): Int {

        return userList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val name : TextView = itemView.findViewById(R.id.sname)
        val adm : TextView = itemView.findViewById(R.id.admno)
        val amount : TextView = itemView.findViewById(R.id.amountt)
        val balance : TextView = itemView.findViewById(R.id.balance)
//        val method : TextView = itemView.findViewById(R.id.method)
        val date : TextView = itemView.findViewById(R.id.date)

    }

}