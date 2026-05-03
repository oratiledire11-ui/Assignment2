package com.example.lifehackapp

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val layout = findViewById<LinearLayout>(R.id.reviewLayout)

        val questions = arrayOf(
            "The Sun is a Star",
            "Humans have walked on Mars",
            "Black holes can trap light",
            "The Milky Way is the only galaxy",
            "Saturn is the planet with the most rings"
        )

        val answers = arrayOf(true, false, true, false, true)

        for (i in questions.indices) {
            val tv = TextView(this)
            val answerRes = if (answers[i]) R.string.hack else R.string.myth
            val answerText = getString(answerRes)
            tv.text = getString(R.string.review_item_format, questions[i], answerText)
            tv.setPadding(0, 0, 0, 20)
            layout.addView(tv)
        }
    }
}