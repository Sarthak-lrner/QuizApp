package com.example.quizapp.data

import com.example.quizapp.R


object Constants {

    fun getQuestions(): ArrayList<Question> {

        val questionsList = ArrayList<Question>()

        val questionText = "What country does this flag belong to?"

        questionsList.add(
            Question(
                id = 1,
                question = questionText,
                image = R.drawable.ic_flag_of_argentina,
                options = mutableListOf(
                    Option("Argentina", true),
                    Option("Australia", false),
                    Option("Armenia", false),
                    Option("Austria", false)
                )
            )
        )

        questionsList.add(
            Question(
                id = 2,
                question = questionText,
                image = R.drawable.ic_flag_of_australia,
                options = mutableListOf(
                    Option("Angola", false),
                    Option("Austria", false),
                    Option("Australia", true),
                    Option("Armenia", false)
                )
            )
        )

        questionsList.add(
            Question(
                id = 3,
                question = questionText,
                image = R.drawable.ic_flag_of_brazil,
                options = mutableListOf(
                    Option("Belarus", false),
                    Option("Belize", false),
                    Option("Brunei", false),
                    Option("Brazil", true)
                )
            )
        )

        questionsList.add(
            Question(
                id = 4,
                question = questionText,
                image = R.drawable.ic_flag_of_belgium,
                options = mutableListOf(
                    Option("Bahamas", false),
                    Option("Belgium", true),
                    Option("Barbados", false),
                    Option("Belize", false)
                )
            )
        )

        questionsList.add(
            Question(
                id = 5,
                question = questionText,
                image = R.drawable.ic_flag_of_fiji,
                options = mutableListOf(
                    Option("Gabon", false),
                    Option("France", false),
                    Option("Fiji", true),
                    Option("Finland", false)
                )
            )
        )

        questionsList.add(
            Question(
                id = 6,
                question = questionText,
                image = R.drawable.ic_flag_of_germany,
                options = mutableListOf(
                    Option("Germany", true),
                    Option("Georgia", false),
                    Option("Greece", false),
                    Option("None of these", false)
                )
            )
        )

        questionsList.add(
            Question(
                id = 7,
                question = questionText,
                image = R.drawable.ic_flag_of_denmark,
                options = mutableListOf(
                    Option("Dominica", false),
                    Option("Egypt", false),
                    Option("Denmark", true),
                    Option("Ethiopia", false)
                )
            )
        )

        questionsList.add(
            Question(
                id = 8,
                question = questionText,
                image = R.drawable.ic_flag_of_india,
                options = mutableListOf(
                    Option("Ireland", false),
                    Option("Iran", false),
                    Option("Hungary", false),
                    Option("India", true)
                )
            )
        )

        questionsList.add(
            Question(
                id = 9,
                question = questionText,
                image = R.drawable.ic_flag_of_new_zealand,
                options = mutableListOf(
                    Option("Australia", false),
                    Option("New Zealand", true),
                    Option("Tuvalu", false),
                    Option("United States of America", false)
                )
            )
        )

        questionsList.add(
            Question(
                id = 10,
                question = questionText,
                image = R.drawable.ic_flag_of_kuwait,
                options = mutableListOf(
                    Option("Kuwait", true),
                    Option("Jordan", false),
                    Option("Sudan", false),
                    Option("Palestine", false)
                )
            )
        )

        return questionsList
    }
}