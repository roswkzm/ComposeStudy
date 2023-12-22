package com.example.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

    @Composable
    fun Greeting() {
        var expandDropDownMenu by remember { mutableStateOf(false) }
        var counter by remember { mutableStateOf(0) }

        Column {
            Button(onClick = { expandDropDownMenu = true }) {
                Text(text = "드롭다운 메뉴 열기")
            }
            Text(text = "카운터 : $counter")
        }

        DropdownMenu(
            expanded = expandDropDownMenu,
            onDismissRequest = {
                expandDropDownMenu = false
            }) {
            DropdownMenuItem(
                text = {
                    Text(text = "증가")
                },
                onClick = {
                    counter++
                }
            )
            DropdownMenuItem(
                text = {
                    Text(text = "감소")
                },
                onClick = {
                    counter--
                }
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