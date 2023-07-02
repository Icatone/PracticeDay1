package com.example.eduproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var nameEdit:EditText? = null
    var heightEdit:EditText? = null
    var weightEdit:EditText? = null
    var ageEdit:EditText? = null
    var button:Button? = null
    var text:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEdit = findViewById<EditText>(R.id.editName)
        heightEdit = findViewById<EditText>(R.id.editHeight)
        weightEdit = findViewById<EditText>(R.id.editWeigth)
        ageEdit = findViewById<EditText>(R.id.editAge)
        button = findViewById(R.id.button)
        text = findViewById(R.id.textView)

        button?.setOnClickListener{
            val name = nameEdit?.text
            val height = Integer.parseInt(heightEdit?.text.toString())
            val weight = weightEdit?.text.toString().toDouble()
            val age = Integer.parseInt(ageEdit?.text.toString())
            var outputData = ""
            if(name?.length!! <=50 &&
                    height <250 &&
                    height>0 &&
                    weight < 250 &&
                    weight > 0 &&
                    age < 150 &&
                    age > 0) {
                val answer = Random((name.length * (weight/height) * age).toInt()).nextInt()
                outputData = "Ответ: $answer"

            }
            else {
                outputData = "Данные введены некорректно."
            }
            text?.text = outputData
            text?.visibility = View.VISIBLE
        }
    }
}