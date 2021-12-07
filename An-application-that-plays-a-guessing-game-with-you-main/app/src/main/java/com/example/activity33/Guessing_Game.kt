package com.example.activity33

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class Guessing_Game : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val randomNum=rand(0,1000)
        var counter=12
        Log.d("Screen2","Random Number Value=$randomNum")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guessing_game)
        val InputNum=findViewById<TextInputLayout>(R.id.TextView_InputNumber)
        val GuessBtn=findViewById<TextView>(R.id.TextView_PushBtn)
        val PredictText=findViewById<TextView>(R.id.TextView_Prediction)
        val ResetBtn=findViewById<TextView>(R.id.TextView_Reset)
        val newScreenIntent=Intent(this,ResultPage::class.java)
        newScreenIntent.putExtra("Value1","$randomNum")
        Log.d("Screen2","Value of Input num=$InputNum")
//        val num=InputNum.editText.toString().toInt() TextInputEditText
        PredictText.setVisibility(View.GONE)
        GuessBtn.setOnClickListener{
            counter--
            val num1= InputNum.editText?.text.toString()
            val num=num1.toInt()
            Log.d("Screen2","Input Number Value=$num")
            PredictText.setVisibility(View.VISIBLE)
            PredictText.text= validaterand(num,randomNum)
            if(PredictText.text=="Congratulations, you have guessed correct number")
            {
                Log.d("Screen2","Moving to next screen")
                newScreenIntent.putExtra("Result","You Won! The Number is")
                startActivity(newScreenIntent)
            }
            else if(counter==0)
            {
                Log.d("Screen2","Moving to next screen")
                newScreenIntent.putExtra("Result","You lost after 12 attempts. The number is")
                startActivity(newScreenIntent)
            }
        }
        ResetBtn.setOnClickListener()
        {
                val newScreenIntent= Intent(this,Guessing_Game::class.java)
                Log.d("Screen2","Reloading with new number")
                startActivity(newScreenIntent)
        }
    }
}
fun rand(start: Int, end: Int):Int {
    require(start <= end) { "Illegal Argument" }
    return (start..end).random()
}
fun validaterand(num:Int,randomNum:Int):String
{
    if(num>randomNum)
      return  "Your Guessed number is greater than actual number"
    else if(num<randomNum)
       return "Your Guessed number is less than actual number"
    else if(randomNum==num)
      return  "Congratulations, you have guessed correct number"
    else
        return "TestCase"

}