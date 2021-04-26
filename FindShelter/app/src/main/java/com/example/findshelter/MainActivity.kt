package com.example.findshelter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_shelter_details.*

class MainActivity : AppCompatActivity(), onShelterClickListener{

    lateinit var shelters: ArrayList<Shelter>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        shelters  = ArrayList()
        addShelter()

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, 1))

        recyclerView.adapter = shelterAdapter(shelters, this)

    }

        fun addShelter() {
            shelters.add(Shelter("Caris House", "6,999","Param park", "0740876540", "param@gmail.com"))
            shelters.add(Shelter("Vanis House", "6,999","South side", "18098743008", "test@gmail.com"))
            shelters.add(Shelter("Dounglas House","7,7888" ,"Para park", "07408754409","houe3@gmail.com"))
            shelters.add(Shelter("Kilim XZ", "34,555","Param park", "07408876544", "uyy@gmail.com"))
            shelters.add(Shelter("Canty Min", "7689","Parama park", "0740887654","canty@gmail.com"))


        }

    override fun onItemClick(item: Shelter, position: Int) {
        val intent = Intent(this, shelterDetails::class.java)
        intent.putExtra("sheltername", item.sheltername)
        intent.putExtra("address", item.address)
        intent.putExtra("suburb", item.suburb)
        intent.putExtra("phone", item.phone)
        intent.putExtra("email", item.email)
        startActivity(intent)


    }
}
