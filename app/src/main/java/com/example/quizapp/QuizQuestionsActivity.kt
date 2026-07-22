package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapp.data.Constants
import com.example.quizapp.data.Question
import com.example.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizQuestionsBinding
    private lateinit var optionAdapter: OptionAdapter
    private var isAnswerSubmitted = false
    private var currentQuestionIndex = 0
    private lateinit var questionsList: ArrayList<Question>
    private var userName = ""
    private var correctAnswers = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvOptions.layoutManager = LinearLayoutManager(this)
        userName = intent.getStringExtra("User Name") ?: ""
        questionsList = Constants.getQuestions()
        setQuestion()
        binding.btnSubmit.setOnClickListener {
            val selectedPosition = optionAdapter.getUserSelectedPosition()
            if (!isAnswerSubmitted) {
                evaluateUserOption(selectedPosition)
            }
            else{
                loadNextQuestion()
            }
        }
        Log.d("QuizActivity", "ActionBar = $supportActionBar")
        
    }

    private fun setQuestion(){
        binding.progressBar.max = questionsList.size
        binding.progressBar.progress = currentQuestionIndex + 1
        binding.tvProgress.text =
            "${currentQuestionIndex + 1}/${questionsList.size}"
        val currentQuestion = questionsList[currentQuestionIndex]
        binding.btnSubmit.text = "Submit"
        binding.tvQuestion.text = currentQuestion.question
        binding.tvImage.setImageResource(currentQuestion.image)
        optionAdapter = OptionAdapter(currentQuestion.options)
        binding.rvOptions.adapter = optionAdapter

    }

     private fun evaluateUserOption(selectedOption: Int) {
        if (selectedOption == -1) {
            // Show Toast
            Toast.makeText(this,"Please select an option",
                Toast.LENGTH_SHORT).show()
            return
        }

         val currentQuestion = questionsList[currentQuestionIndex]

        val correctOption = currentQuestion.options.indexOfFirst {
            it.isCorrect
        }

        if (currentQuestion.options[selectedOption].isCorrect) {
            correctAnswers++
        }

        optionAdapter.updateAnswerState(
            true,
            selectedOption,
            correctOption
        )
         binding.btnSubmit.text = "Go To Next Question"
         isAnswerSubmitted=true
    }
    private fun loadNextQuestion(){
        if(currentQuestionIndex<questionsList.size - 1){
            currentQuestionIndex++
            isAnswerSubmitted = false
            setQuestion()
        }else{
            // Open ResultActivity
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("Correct Answers",correctAnswers)
            intent.putExtra("Total Questions", questionsList.size)
            intent.putExtra("User Name", userName)
            startActivity(intent)
            finish()
        }
    }
}