package com.example.quizapp.data

data class Question(
    val id: Int,
    val question: String,
    val image: Int,
    val options: MutableList<Option>

)

data class Option(
    val text: String,
    val isCorrect: Boolean
)
