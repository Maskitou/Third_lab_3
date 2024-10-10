package com.mobile_systems.third_lab_3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var inputText: EditText
    private lateinit var countButton: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputText = findViewById(R.id.inputText)
        countButton = findViewById(R.id.countButton)
        resultText = findViewById(R.id.resultText)

        countButton.setOnClickListener {
            val text = inputText.text.toString()
            val count = countLatinLetters(text)
            resultText.text = "Количество латинских букв: $count"
        }
    }

    private fun countLatinLetters(input: String): Int {
        return input.count { it.isLetter() && it.isLetterOf(26) }
    }

    private fun Char.isLetterOf(range: Int): Boolean {
        return this in 'A'..'Z' || this in 'a'..'z'
    }
}