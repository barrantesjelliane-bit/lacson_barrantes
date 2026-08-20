package com.example.unscrambleapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private val words = listOf(
        "CAT",
        "DOG",
        "BOOK"
    )

    var userAnswer by mutableStateOf("")
        private set

    var currentWordIndex by mutableIntStateOf(0)
        private set

    var score by mutableIntStateOf(0)
        private set

    var scrambledWord by mutableStateOf(
        words[0]
            .toList()
            .shuffled()
            .joinToString("")
    )
        private set

    private val correctAnswer: String
        get() = words[currentWordIndex]

    fun updateUserAnswer(answer: String) {
        userAnswer = answer
    }

    fun checkAnswer() {
        if (
            userAnswer.equals(
                correctAnswer,
                ignoreCase = true
            )
        ) {
            score++
            nextWord()
        }
    }

    private fun nextWord() {
        if (currentWordIndex < words.size - 1) {
            currentWordIndex++
            userAnswer = ""

            scrambledWord = words[currentWordIndex]
                .toList()
                .shuffled()
                .joinToString("")
        }
    }
}