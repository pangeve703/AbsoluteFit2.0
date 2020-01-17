package com.example.absolutefit


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.net.Uri


class RecipeActivity: AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        val button1: Button = findViewById(R.id.button1) as Button
        button1.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("http://www.delish.com/cooking/recipe-ideas/recipes/a11249/grilled-deviled-chickens-under-brick-mslo0510-recipe/")
            startActivity(openURL)
        }

        val button2: Button = findViewById(R.id.button2) as Button
        button2.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("http://www.seriouseats.com/recipes/2011/06/stir-fried-rice-with-chinese-sausage-recipe.html")
            startActivity(openURL)
        }
        val button3: Button = findViewById(R.id.button3) as Button
        button3.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("http://www.epicurious.com/recipes/food/views/Five-Spice-Chicken-Wings-109520")
            startActivity(openURL)
        }
        val button4: Button = findViewById(R.id.button4) as Button
        button4.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("http://www.seriouseats.com/recipes/2009/07/grilling-chinese-style-spare-ribs-recipe.html")
            startActivity(openURL)
        }
        val button5: Button = findViewById(R.id.button5) as Button
        button5.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("http://www.seriouseats.com/recipes/2010/11/seriously-asian-korean-rice-cakes-dok-boki.html")
            startActivity(openURL)
        }
        val button6: Button = findViewById(R.id.button6) as Button
        button6.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("http://www.epicurious.com/recipes/member/views/DUMP-CAKE-50059991")
            startActivity(openURL)
        }
        val button7: Button = findViewById(R.id.button7) as Button
        button7.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("http://www.seriouseats.com/recipes/2008/12/sugar-cookies-recipe-gina-depalma-holidays.html")
            startActivity(openURL)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main2, menu)
        return true
    }
}


