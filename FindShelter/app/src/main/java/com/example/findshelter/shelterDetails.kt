package com.example.findshelter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_shelter_details.*
import kotlinx.android.synthetic.main.list_shelter.*
import kotlinx.android.synthetic.main.list_shelter.phone
import kotlinx.android.synthetic.main.list_shelter.suburb
import kotlinx.android.synthetic.main.activity_shelter_details.address as address1
import kotlinx.android.synthetic.main.activity_shelter_details.email as email1
import kotlinx.android.synthetic.main.activity_shelter_details.sheltername as sheltername1

class shelterDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shelter_details)

        sheltername.text = getIntent().getStringExtra("sheltername")
        address.text = getIntent().getStringExtra("address")
        suburb.text = getIntent().getStringExtra("suburb")
        phone.text = getIntent().getStringExtra("phone")
        email.text = getIntent().getStringExtra("email")

    }
}
