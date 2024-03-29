package com.example.absolutefit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.absolutefit.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val taruc = LatLng(3.216364, 101.728985)
        mMap.addMarker(MarkerOptions().position(taruc).title("Marker in TARUC"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(taruc))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(taruc,18.0f));
    }
}
