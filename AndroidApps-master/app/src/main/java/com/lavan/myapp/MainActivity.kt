package com.lavan.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.lavan.myapp.api.UserAPIService
import com.lavan.myapp.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.button)
        var userAPIService= UserAPIService.create()
        var textView=findViewById<TextView>(R.id.textView)

        button.setOnClickListener(){
           // Log.i("msg", "12")
            var id=findViewById<EditText>(R.id.editText).text.toString()
            //Log.i("id",id)
            var user=userAPIService.getUser(id)
            user.enqueue(object :Callback <User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    var body=response.body()
                    body?.let {
                        textView.text= "Id: ${it.id}\nName: ${it.name}\nUserName: ${it.username}\nEmail: ${it.email}"
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }
    }
}