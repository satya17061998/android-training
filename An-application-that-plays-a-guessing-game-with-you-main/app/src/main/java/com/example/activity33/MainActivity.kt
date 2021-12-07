package com.example.activity33

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Screen1","Activity to be started")
        findViewById<TextView>(R.id.TextView_Welcome).setOnClickListener{
            val newScreenIntent=Intent(this,Guessing_Game::class.java)
            Log.d("Screen1","Moving to next screen")
            startActivity(newScreenIntent)
        }
    }
}