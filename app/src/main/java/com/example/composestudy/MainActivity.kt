package com.example.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composestudy.ui.theme.ComposeStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Greeting() {
        var helloWorldVisible by remember { mutableStateOf(true) }
        var isRed by remember { mutableStateOf(false) }

        val backgroundColor by animateColorAsState(
            targetValue = if (isRed) Color.Red else Color.White
        )

        val alpha by animateFloatAsState(
            targetValue = if (isRed) 1.0f else 0.5f
        )

        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(backgroundColor)
                .alpha(alpha)
        ) {
            AnimatedVisibility(
                visible = helloWorldVisible,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Text(text = "Hello World!")
            }

            Row(
                Modifier.selectable(
                    selected = helloWorldVisible,
                    onClick = {
                        helloWorldVisible = true
                    }
                ),
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(
                    selected = helloWorldVisible,
                    onClick = { helloWorldVisible = true }
                )
                Text(text = "Hello World 보이기")
            }

            Row(
                Modifier.selectable(
                    selected = !helloWorldVisible,
                    onClick = {
                        helloWorldVisible = false
                    }
                ),
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(
                    selected = !helloWorldVisible,
                    onClick = { helloWorldVisible = false }
                )
                Text(text = "Hello World 보이기")
            }

            Text(text = "배경 색을 바꾸어 봅시다.")

            Row(
                Modifier.selectable(
                    selected = !isRed,
                    onClick = {
                        isRed = false
                    }
                ),
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(
                    selected = !isRed,
                    onClick = { isRed = false }
                )
                Text(text = "흰색")
            }

            Row(
                Modifier.selectable(
                    selected = isRed,
                    onClick = {
                        isRed = true
                    }
                ),
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(
                    selected = isRed,
                    onClick = { isRed = true }
                )
                Text(text = "빨간색")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeStudyTheme {
            Greeting()
        }
    }
}