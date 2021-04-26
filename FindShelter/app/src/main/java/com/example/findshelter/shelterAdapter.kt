package com.example.findshelter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_shelter.view.*

class shelterAdapter(val shelterList: ArrayList<Shelter>,var clickListner: onShelterClickListener) : RecyclerView.Adapter<shelterAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): shelterAdapter.ViewHolder {
        lateinit var shelterViewHolder : ViewHolder
        shelterViewHolder = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_shelter,parent,false ))
        return shelterViewHolder
    }

    override fun getItemCount(): Int {
        return shelterList.size
    }

    override fun onBindViewHolder(holder: shelterAdapter.ViewHolder, position: Int) {
        holder.initialize(shelterList.get(position),clickListner)

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var sheltername = itemView.sheltername
      //  var address = itemView.address
        var suburb = itemView.suburb
        var phone = itemView.phone
        //var email = itemView.email

        fun initialize(shelter: Shelter, action:onShelterClickListener) {

            sheltername.text = shelter.sheltername
           // address.text = shelter.address
            suburb.text = shelter.suburb
            phone.text = shelter.phone
            //email.text = shelter.email


            itemView.setOnClickListener {
                action.onItemClick(shelter,adapterPosition)
            }



        }
    }

}