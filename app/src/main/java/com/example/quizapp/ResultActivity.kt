package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.databinding.ActivityResultBinding
import java.util.Locale.getDefault

class ResultActivity : AppCompatActivity() {
    private var userName = ""
    private var correctAnswers = -1
    private var totalQuestions = -1
    private lateinit var binding : ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userName = intent.getStringExtra("User Name") ?: ""
        totalQuestions = intent.getIntExtra("Total Questions",-1)
        correctAnswers = intent.getIntExtra("Correct Answers",-1)

        binding.tvName.text = userName.uppercase(getDefault())
        binding.tvScore.text =
            "Your Score is $correctAnswers out of $totalQuestions"

        binding.btnFinish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}