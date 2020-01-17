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
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.nav_header_main2.*
import androidx.core.content.ContextCompat.startActivity
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class LoginActivity : AppCompatActivity() {
    lateinit var goToRegisterBtn:TextView
    lateinit var ctx: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val toolbar: Toolbar = findViewById(R.id.toolbar1)
        setSupportActionBar(toolbar)

        val chkemail:EditText = findViewById<EditText>(R.id.textInputEditTextEmail)
        val chkpwd:EditText= findViewById<EditText>(R.id.textInputEditTextPassword)
        goToRegisterBtn = findViewById(R.id.textViewLinkRegister)
        ctx=this

        goToRegisterBtn.setOnClickListener(){
            val intentGoToRegisterActivity = Intent(this,RegisterActivity::class.java)
            startActivity(intentGoToRegisterActivity)
        }

        var loginBtn:Button = findViewById(R.id.appCompatButtonLogin) as Button
        loginBtn.setOnClickListener(){
           var emailLogin = chkemail.text.toString().trim()
            var passwordLogin = chkpwd.text.toString().trim()


            if(emailLogin.isEmpty()){
                chkemail.error = "Please enter your email"
            }
            if(passwordLogin.isEmpty()){
                chkpwd.error = "Please enter your password"
            }
            val ref = FirebaseDatabase.getInstance().getReference("Account").child("-Ly_MIi_BaEuR8TWZn2t")
            ref.addValueEventListener(object :ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {
                    //Log.w(TAG, "postComments:onCancelled", databaseError.toException())
                    Toast.makeText(applicationContext, "Failed to load comments.",
                        Toast.LENGTH_SHORT).show()
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    var myemail:String = dataSnapshot.child("emailR").getValue().toString()
                    var mypassword:String = dataSnapshot.child("passwordR").getValue().toString()
                    var myname:String =dataSnapshot.child("name").getValue().toString()


                   //To change body of created functions use File | Settings | File Templates.
                    //val posts = ArrayList<Account>()
                   //for (snapshot in dataSnapshot.children) {
                        //al post = snapshot.getValue(Account::class.java)
                        //posts.add(post!!)
                    if(chkemail.text.toString().equals(myemail) && chkpwd.text.toString().equals(mypassword)){
                        val intentGoToMainActivity = Intent(ctx, MainActivity::class.java)
                        ctx.startActivity(intentGoToMainActivity)
                        Toast.makeText(applicationContext,"Welcome " + myname ,Toast.LENGTH_LONG).show()
                    }
                    else
                        Toast.makeText(applicationContext,"Wrong email or password",Toast.LENGTH_LONG).show()


                }


            })

            /*val intentGoToMainActivity= Intent(this,MainActivity::class.java)
            startActivity(intentGoToMainActivity)*/
        }
    }

}

