package com.example.samplepost

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.samplepost.data.User
import com.example.samplepost.data.UserReq
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences=getSharedPreferences("user",Context.MODE_PRIVATE)
        val token=sharedPreferences.getString("token",null)
        findViewById<TextView>(R.id.result).text=token.toString()

        findViewById<Button>(R.id.button).setOnClickListener()
        {
            val mail=findViewById<EditText>(R.id.mail).text
            val password=findViewById<EditText>(R.id.password).text
            val user=UserReq(mail.toString(),password.toString())
            CoroutineScope(Dispatchers.IO).launch {
                val sampleApplication=application as SampleApplication
                val service=sampleApplication.api
                service.postData(user).enqueue(object : Callback<User?> {
                    override fun onResponse(call: Call<User?>, response: Response<User?>) {
                        if(response.isSuccessful)
                        {
                            findViewById<TextView>(R.id.result).text=response.body().toString()
                            val sharedPreferences=getSharedPreferences("user", Context.MODE_PRIVATE)
                            val editor=sharedPreferences.edit()
                            editor.apply()
                            {
                                putString("token",response.body()!!.token)
                            }.apply()

                        }
                        else
                        {
                            findViewById<TextView>(R.id.result).text="Invalid User"
                        }
                    }

                    override fun onFailure(call: Call<User?>, t: Throwable) {
                        findViewById<TextView>(R.id.result).text=t.message
                    }
                })
            }
        }
    }
}