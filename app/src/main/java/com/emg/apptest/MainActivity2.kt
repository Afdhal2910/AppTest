package com.emg.apptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    var mFirstName:String? = ""
    var mLastName:String? = ""
    var mEmail:String? = ""
    var mPhone:String? = ""

    lateinit var firstName: TextView
    lateinit var lastName: TextView
    lateinit var email: TextView
    lateinit var phone: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        firstName = findViewById<TextView>(R.id.first_name_tv)
        lastName = findViewById<TextView>(R.id.last_name_tv)
        email = findViewById<TextView>(R.id.email_tv)
        phone = findViewById<TextView>(R.id.phone_tv)

        val bundle:Bundle? = intent.extras
        if(bundle!=null){
            mFirstName = bundle.getString("first_name")
            mLastName = bundle.getString("last_name")
            mEmail = bundle.getString("email")
            mPhone = bundle.getString("phone")

            Log.d("JADI", mFirstName.toString())

            firstName.text = "First Name = " + mFirstName
            lastName.text = "Last Name = " + mLastName
            email.text = "Email = " + mEmail
            phone.text = "Phone = " + mPhone
        }
    }
}