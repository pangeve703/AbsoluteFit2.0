package com.example.absolutefit

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_calculate_bmi.*
import java.lang.Math.pow
import kotlin.math.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import java.lang.Exception


class InfoActivity : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_center_info)

        val addressButton: Button = findViewById(R.id.address_btn) as Button
        addressButton.setOnClickListener {
            Toast.makeText(this@InfoActivity, "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show()
            val intentGoToMapActivity= Intent(this,MapsActivity::class.java)
            startActivity(intentGoToMapActivity)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main2, menu)
        return true
    }

}
