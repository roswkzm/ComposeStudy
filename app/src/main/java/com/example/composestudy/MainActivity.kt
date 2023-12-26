package com.example.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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
        var pyeong by rememberSaveable { mutableStateOf("23") }
        var squaremeter by rememberSaveable { mutableStateOf((23 * 3.306).toString()) }

        PyeongToSquareMeterStateless(
            pyeong,
            squaremeter
        ) {
            if (it.isBlank()) {
                pyeong = ""
                squaremeter = ""
                return@PyeongToSquareMeterStateless
            }
            val numericValue = it.toFloatOrNull() ?: return@PyeongToSquareMeterStateless
            pyeong = it
            squaremeter = (numericValue * 3.306).toString()
        }

//        Column(
//            modifier = Modifier.padding(16.dp)
//        ) {
//            OutlinedTextField(
//                value = pyeong,
//                onValueChange = {
//                    if (it.isBlank()){
//                        pyeong = ""
//                        squaremeter = ""
//                        return@OutlinedTextField
//                    }
//                    val numericValue = it.toFloatOrNull() ?: return@OutlinedTextField
//                    pyeong = it
//                    squaremeter = (numericValue * 3.306).toString()
//                },
//                label = {
//                    Text(text = "평")
//                },
//                colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color.Black)
//            )
//
//            OutlinedTextField(
//                value = squaremeter,
//                onValueChange = {
//
//                },
//                label = {
//                    Text(text = "제곱미터")
//                },
//                colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color.Black)
//            )
//        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun PyeongToSquareMeterStateless(
        pyeong: String,
        squareMeter: String,
        onPyeongChange: (String) -> Unit
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            OutlinedTextField(
                value = pyeong,
                onValueChange = {
                    onPyeongChange
                },
                label = {
                    Text(text = "평")
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color.Black)
            )

            OutlinedTextField(
                value = squareMeter,
                onValueChange = {

                },
                label = {
                    Text(text = "제곱미터")
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color.Black)
            )
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