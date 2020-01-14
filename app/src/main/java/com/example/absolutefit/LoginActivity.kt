package com.example.absolutefit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.nav_header_main2.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var loginBtn:Button = findViewById(R.id.appCompatButtonLogin) as Button
        loginBtn.setOnClickListener(){
            login()
        }
    }

    private fun login() {
        var ref = FirebaseDatabase.getInstance().getReference("Account")


        val menuListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var acc = dataSnapshot.getValue() as Account
                var abc=acc.emailR
                Toast.makeText(applicationContext,abc,Toast.LENGTH_LONG).show()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // handle error
            }
        }
        ref.addListenerForSingleValueEvent(menuListener)

    }
}

