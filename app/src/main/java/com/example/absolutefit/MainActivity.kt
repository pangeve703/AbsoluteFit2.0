package com.example.absolutefit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bmiButton: ImageButton = findViewById(R.id.calbmi_btn) as ImageButton
        bmiButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show()
            val intentGoToCalculateBMI = Intent(this,CalculateBMI::class.java)
            startActivity(intentGoToCalculateBMI)
        }
    }


}
