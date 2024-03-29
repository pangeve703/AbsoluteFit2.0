package com.example.absolutefit

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_calculate_bmi.view.*

class RegisterActivity : AppCompatActivity() {

    lateinit var name_register: EditText
    lateinit var email_register: EditText
    lateinit var password_register: EditText
    lateinit var confirmPwd:EditText
    lateinit var emailPattern: String
    lateinit var context: Context
    lateinit var btnRegister:Button
    lateinit var goToLoginBtn:TextView

    internal var TAG = MainActivity::class.java.simpleName
    //var register_btn:Button = findViewById(R.id.registerBtn) as Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val toolbar: Toolbar = findViewById(R.id.toolbar1)
        setSupportActionBar(toolbar)

        name_register = findViewById(R.id.name_inputs)
        email_register =findViewById(R.id.textInputEditTextEmail)
        password_register = findViewById(R.id.password)
        confirmPwd = findViewById(R.id.conPwd)
        btnRegister= findViewById(R.id.registerBtn) as Button
        goToLoginBtn = findViewById(R.id.textViewLinkLogin)
        btnRegister.setOnClickListener(){
            saveAccount()
        }
        goToLoginBtn.setOnClickListener(){
            val intentGoToLoginActivity = Intent(this,LoginActivity::class.java)
            startActivity(intentGoToLoginActivity)
        }
    }

    private fun saveAccount(){
        val name = name_register.text.toString().trim()
        val emailR = email_register.text.toString().trim()
        val passwordR = password_register.text.toString().trim()
        val conPwdR = confirmPwd.text.toString().trim()
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
        if(conPwdR.isEmpty()){
            confirmPwd.error = "Please enter your password again"
            return
        }
        if(!conPwdR.equals(passwordR)){
            confirmPwd.error = "The password is not match"
        }
        try {
            context = this
            emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.+[a-z]+"


            if (email_register.text.toString().trim { it <= ' ' }.matches(emailPattern.toRegex())&&conPwdR.equals(passwordR)) {

                val ref = FirebaseDatabase.getInstance().getReference("Account")
                val userId = ref.push().key

                val acc = Account(userId.toString(),name,emailR,passwordR)
                ref.child(userId.toString()).setValue(acc).addOnCompleteListener(){
                    Toast.makeText(applicationContext,"Account created successfully",Toast.LENGTH_LONG).show()
                    val intentGoToMainActivity = Intent(context, MainActivity::class.java)
                    context.startActivity(intentGoToMainActivity)
                }
            } else if(!email_register.text.toString().trim { it <= ' ' }.matches(emailPattern.toRegex())){
                Toast.makeText(context, "Please enter valid email", Toast.LENGTH_LONG).show()
            }

        } catch (ex: Exception) {
            Log.e(TAG, ex.message)
        }


    }
}
