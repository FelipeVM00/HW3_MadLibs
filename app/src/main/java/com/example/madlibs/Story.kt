package com.example.madlibs

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_story.*
import java.io.BufferedReader
import java.io.PrintStream
import java.util.*
import kotlin.collections.ArrayList

class Story : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)
        val inputs = intent.getStringArrayListExtra("inputs")
        val storyID = intent.getIntExtra("storyID", 0)
        writer(inputs, storyID)
    }

    fun writer(inputs: ArrayList<String>, storyID: Int){
        val builder = StringBuilder()
        val reader = Scanner(resources.openRawResource(storyID))

        val first_line = reader.nextLine()
        builder.append(first_line)
        while(reader.hasNextLine()){
            val line = reader.nextLine()
            builder.append(" ")
            builder.append(line)
        }

        var story = builder.toString()

        val r = Regex("<.*?>")
        val blanks = r.findAll(story).map { it.value }
        var i: Int = 0
        for(blank in blanks){
            story = story.replaceFirst(blank, inputs.get(i))
            i++
        }
        story_text.text = "$story"
    }


    fun makeNew(view: View){
        val myIntent = Intent(this, MainActivity::class.java)
        startActivity(myIntent)
    }
}
