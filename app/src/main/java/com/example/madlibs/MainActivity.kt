package com.example.madlibs

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.TextView
import android.view.ViewGroup



class MainActivity : AppCompatActivity() {

    private val REQ_CODE = 124
    val StoryArray = arrayOf("hints", "short_story", "madlib1_tarzan")
    var Story_title = "hints"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun gameStartClick(view: View){


        val index = story_menu.selectedItemPosition;
        val Story_title = StoryArray[index];

        if (Story_title == "hints"){
            val Toast = Toast.makeText(this, "Choose a story !", Toast.LENGTH_SHORT)
            Toast.show()
        }
        else{
            val myIntent = Intent(this, Fillwords::class.java)
            myIntent.putExtra("story", Story_title)
            startActivityForResult(myIntent, REQ_CODE) // jump to the story page
        }
    }
}


