package com.example.absolutefit

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Handler
import android.os.SystemClock
import android.widget.Button
import android.widget.ListView
import java.util.*


class TimerActivity: AppCompatActivity() {

/*
    var millisecondTime: Long = 0
    var startTime: Long = 0
    var timeBuff: Long = 0
    var updateTime = 0L

    var handler: Handler? = null

    var seconds: Int = 0
    var minutes: Int = 0
    var milliSeconds: Int = 0

    var listView: ListView? = null

    var ListElements = arrayOf<String>()

    var ListElementsArrayList: List<String>? = null

    var adapter: ArrayAdapter<String>? = null
    */

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
    }
}
      /*  var text: TextView = findViewById(R.id.textView) as TextView;
        var start: Button = findViewById(R.id.button) as Button;
        var pause: Button = findViewById(R.id.button2) as Button;
        var reset: Button = findViewById(R.id.button3) as Button;
        var lap: Button = findViewById(R.id.button4) as Button;
        var list: ListView = findViewById(R.id.listview1) as ListView;

        var handler: Handler = Handler();

        var ListElementsArrayList: List<String> =
            new ArrayList < String >(Arrays.asList(ListElements));

        adapter = new ArrayAdapter < String >(
            MainActivity.this,
            android.R.layout.simple_list_item_1,
            ListElementsArrayList
        );

        listView.setAdapter(adapter);

        start.setOnClickListener() {

            startTime = SystemClock.uptimeMillis();
            handler.postDelayed(runnable, 0);

            reset.setEnabled(false);

        }
        ;

        pause.setOnClickListener() {

            timeBuff += millisecondTime;

            handler.removeCallbacks(runnable);

            reset.setEnabled(true);

        };

        reset.setOnClickListener() {


            millisecondTime = 0L;
            startTime = 0L;
            timeBuff = 0L;
            updateTime = 0L;
            seconds = 0;
            minutes = 0;
            milliSeconds = 0;

            text.setText("00:00:00");

            ListElementsArrayList.clear();

            adapter.notifyDataSetChanged();
        };

        lap.setOnClickListener() {

            ListElementsArrayList.add(textView.getText().toString());

            adapter.notifyDataSetChanged();

        }

        public Runnable runnable = new Runnable () {

            public void run() {

                millisecondTime = SystemClock.uptimeMillis() - startTime;

                updateTime = timeBuff + millisecondTime;

                seconds = (int)(updateTime / 1000);

                minutes = seconds / 60;

                seconds = seconds % 60;

                milliSeconds = (int)(updateTime % 1000);

                text.setText(
                    "" + minutes + ":"
                            + String.format("%02d", seconds) + ":"
                            + String.format("%03d", milliSeconds)
                );

                handler.postDelayed(this, 0);
            }

        }
    }*/



