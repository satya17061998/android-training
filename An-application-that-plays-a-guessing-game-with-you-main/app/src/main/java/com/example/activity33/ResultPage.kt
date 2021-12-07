package com.example.activity33

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ResultPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_page)
        val ResultText=findViewById<TextView>(R.id.TextView_Result)
        val ResultValue=findViewById<TextView>(R.id.TextView_Value)
        val resultguess=intent.getStringExtra("Result")
        val resultvalueguess=intent.getStringExtra("Value1")
        Log.d("Screen3",resultguess.toString())
        Log.d("Screen3",resultvalueguess.toString())
        if(resultguess=="You Won! The Number is")
        {
            ResultText.text=resultguess
            ResultValue.setTextColor(Color.GREEN)
            ResultValue.text=resultvalueguess
        }
        else
        {
            ResultText.text=resultguess
            ResultValue.setTextColor(Color.RED)
            ResultValue.text=resultvalueguess
        }
    }
}