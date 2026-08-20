package com.example.unscrambleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.unscrambleapp.ui.theme.UnscrambleAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val gameViewModel = ViewModelProvider(this)[GameViewModel::class.java]

        setContent {
            UnscrambleAppTheme {

                GameScreen(
                    gameViewModel = gameViewModel
                )
            }
        }
    }
}

@Composable
fun GameScreen(
    gameViewModel: GameViewModel
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "UNSCRAMBLE",
            fontSize = 30.sp
        )

        Text(
            text = gameViewModel.scrambledWord,
            fontSize = 40.sp
        )

        Text(
            text = "Unscramble the word!"
        )

        OutlinedTextField(
            value = gameViewModel.userAnswer,
            onValueChange = {
                gameViewModel.updateUserAnswer(it)
            },
            label = {
                Text("Enter your answer")
            }
        )

        Button(
            onClick = {
                gameViewModel.checkAnswer()
            }
        ) {
            Text("SUBMIT")
        }

        Text(
            text = "Score: ${gameViewModel.score}"
        )
    }
}