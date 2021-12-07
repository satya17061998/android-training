package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var clickCount=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clickCountDisplayColor=findViewById<TextView>(R.id.clickCountView)
        val clickMeButton=findViewById<TextView>(R.id.clickButton)
        clickMeButton.setOnClickListener{
            clickCount++
            clickCountDisplayColor.text="Purple Button Clicked"
        }
        val clickMeButton1=findViewById<TextView>(R.id.clickButton_black)
        clickMeButton1.setOnClickListener{
            clickCount++
            clickCountDisplayColor.text="Black Button Clicked"
         
        }
        val clickMeButton2=findViewById<TextView>(R.id.clickButton_orange)
        clickMeButton2.setOnClickListener{
            clickCount++
            clickCountDisplayColor.text="Orange Button Clicked"
        }
    }
}