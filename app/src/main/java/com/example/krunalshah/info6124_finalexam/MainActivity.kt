package com.example.krunalshah.info6124_finalexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()

        transaction.add(R.id.mapLinearLayout, MapsFragment())
        transaction.add(R.id.latLngLinearLayout, LatLngFragment())
        transaction.add(R.id.addressLinearLayout, AddressFragment())

        transaction.commit()
    }
}