package com.example.task22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    var clickCountMap= mutableMapOf<String,Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickCountDisplayColor=findViewById<TextView>(R.id.clickCountView)
        val clickCountDisplayInfo=findViewById<TextView>(R.id.InfoClickCount)
        val clickMeButton=findViewById<TextView>(R.id.clickButton)
        val nameInputTextView=findViewById<TextInputLayout>(R.id.nameTextInput)
        var usercount=clickCountMap.size
        clickMeButton.setOnClickListener{
            val username=nameInputTextView.editText?.text?.toString()
            val maskedUsername:String
            maskedUsername=
                if(username.isNullOrEmpty()) {"Somebody" }
                else
                { username }
            val oldClickCount=clickCountMap(maskedUsername)?:0
            val newClickCount=oldClickCount+1
            clickCountMap(maskedUsername)=newClickCount
            clickCountDisplayColor.text = "$maskedUsername clicked purple button $newClickCount times"
            clickCountDisplayInfo.text=  "Total number of Users are $usercount"
//            Log.d("keys","UserMap Keys= ${UsersMap.keys}")
//            Log.d("keys","UserClickMap Keys= ${UserClickMap.keys}")
//            if(maskedUsername in UserClickMap) {
//                Log.d("Loop","If loop executed")
//                    var item=UserClickMap.get(maskedUsername)
//                    item= item?.inc()
//                    clickCountDisplayColor.text = "$maskedUsername clicked purple button $item times"
//                    UserClickMap-maskedUsername
//                    UserClickMap+Pair(maskedUsername,item)
//            }
//            else
//            {
//                Log.d("Loop","Else loop executed")
//                usercount++
//                UsersMap+Pair(usercount, maskedUsername)
//                trickycount++
//                UserClickMap+Pair(maskedUsername,trickycount)
//
//
//            }
//
        }

    }
}