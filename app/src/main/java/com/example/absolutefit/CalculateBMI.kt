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


class CalculateBMI : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_bmi)
        val toolbar: Toolbar = findViewById(R.id.toolbar1)
        setSupportActionBar(toolbar)


        val calBMIBtn:Button = findViewById(R.id.calBMI_btn) as Button
        calBMIBtn.setOnClickListener(){
            try {

                val height:Double = (height_input.text.toString().toDouble())/100
                val weight:Double = weight_input.text.toString().toDouble()
                val result:Double =weight/ (height * height )

                if(result<=25&&result>=20){
                    result_txt_view.setTextColor(getColor(R.color.green))
                }
                else if (result<=30&&result>=25){
                    result_txt_view.setTextColor(getColor(R.color.yellow))
                }
                else if(result<=40&&result>=30){
                    result_txt_view.setTextColor(getColor(R.color.orange))
                }
                else
                    result_txt_view.setTextColor(getColor(R.color.red))

                result_txt_view.setText("%.2f".format(result))
            } catch (e: Exception) {
                Toast.makeText(this@CalculateBMI, "Please enter your height,weight and age", Toast.LENGTH_SHORT).show()
            }
        }
        val resetBtn:Button = findViewById(R.id.resetBMI_btn) as Button
        resetBtn.setOnClickListener(){
            height_input.setText("")
            weight_input.setText("")
            age_input.setText("")
            result_txt_view.setText("")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main2, menu)
        return true
    }

}
