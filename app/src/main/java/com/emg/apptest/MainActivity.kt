package com.emg.apptest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    lateinit var jsonList: ListView

    var arrList = arrayListOf<String>()
    var firstName = arrayListOf<String>()
    var lastName = arrayListOf<String>()
    var email = arrayListOf<String>()
    var phone = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jsonList = findViewById<ListView>(R.id.json_list)
        readJson()
    }

    private fun readJson() {
        var json: String? = null
        try {
            val inputStream: InputStream = assets.open("data.json")
            json = inputStream.bufferedReader().use{it.readText()}

            var jsonArray = JSONArray(json)
            for(i in 0..jsonArray.length()-1)
            {
                var jsonObj = jsonArray.getJSONObject(i)
                val fName = jsonObj.getString("firstName")
                val lName = jsonObj.getString("lastName")

                arrList.add(fName + " " + lName)
                firstName.add(jsonObj.getString("firstName"))
                lastName.add(jsonObj.getString("lastName"))
                email.add(jsonObj.getString("email"))
                phone.add(jsonObj.getString("phone"))
            }

            var displayData = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrList )
            jsonList.adapter = displayData

            jsonList.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
                val intent = Intent(applicationContext, MainActivity2::class.java)
                intent.putExtra("first_name", firstName[i])
                intent.putExtra("last_name", lastName[i])
                intent.putExtra("email",email[i])
                intent.putExtra("phone",phone[i])
                startActivity(intent)
            }
        }catch (e: IOException){

        }
    }
}