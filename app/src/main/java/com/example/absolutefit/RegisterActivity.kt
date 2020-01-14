package com.example.absolutefit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_calculate_bmi.view.*

class RegisterActivity : AppCompatActivity() {

    lateinit var name_register: EditText
    lateinit var email_register: EditText
    lateinit var password_register: EditText
    //var register_btn:Button = findViewById(R.id.registerBtn) as Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        name_register = findViewById(R.id.name_inputs)
        email_register =findViewById(R.id.textInputEditTextEmail)
        password_register = findViewById(R.id.password)
        val btnRegister : Button = findViewById(R.id.registerBtn) as Button
        btnRegister.setOnClickListener(){
            saveAccount()
        }
    }

    private fun saveAccount(){
        val name = name_register.text.toString().trim()
        val emailR = email_register.text.toString().trim()
        val passwordR = password_register.text.toString().trim()

        if(name.isEmpty()){
            name_register.error = "Please enter your name"
            return
        }
        if(emailR.isEmpty()){
            email_register.error = "Please enter your email"
            return
        }
        if(passwordR.isEmpty()){
            password_register.error = "Please enter your password"
            return
        }

        val ref = FirebaseDatabase.getInstance().getReference("Account")
        val userId = ref.push().key

        val acc = Account(userId.toString(),name,emailR,passwordR)
        ref.child(userId.toString()).setValue(acc).addOnCompleteListener(){
            Toast.makeText(applicationContext,"Account created",Toast.LENGTH_LONG).show()
        }

    }
}
