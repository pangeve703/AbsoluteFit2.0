package com.example.absolutefit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar1)
        setSupportActionBar(toolbar)


        val bmiButton: ImageButton = findViewById(R.id.calbmi_btn) as ImageButton
        bmiButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show()
            val intentGoToCalculateBMI = Intent(this,CalculateBMI::class.java)
            startActivity(intentGoToCalculateBMI)
        }

        val signUpButton: ImageButton = findViewById(R.id.signUp_btn) as ImageButton
        signUpButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show()
            val intentGoToMain2Activity = Intent(this,Main2Activity::class.java)
            startActivity(intentGoToMain2Activity)
        }
        val infoButton: ImageButton = findViewById(R.id.info_btn) as ImageButton
        infoButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show()
            val intentGoToInfoActivity= Intent(this,InfoActivity::class.java)
            startActivity(intentGoToInfoActivity)
        }

        val timerButton: ImageButton = findViewById(R.id.news_btn) as ImageButton
        timerButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "TESTING BUTTON CLICK 1", Toast.LENGTH_SHORT).show()
            val intentGoToTimerActivity= Intent(this,TimerActivity::class.java)
            startActivity(intentGoToTimerActivity)
        }




    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.action_login -> {
                val intentGoToLoginActivity = Intent(this,LoginActivity::class.java)
                startActivity(intentGoToLoginActivity)
                true
            }
            R.id.action_signup -> {
                val intentGotoRegisterActivity = Intent(this,RegisterActivity::class.java)
                startActivity(intentGotoRegisterActivity)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }

}
