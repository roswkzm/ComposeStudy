package com.example.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
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
        var openDialog by remember { mutableStateOf(false) }
        var counter by remember { mutableStateOf(0) }

        Column {
            Button(onClick = { openDialog = true }) {
                Text(text = "다이얼로그 열기")
            }
            Text(text = "카운터 : $counter")
        }

        if (openDialog) {
            Dialog(onDismissRequest = {
                openDialog = false
            }) {
                Surface {
                    Column(
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(text = "버튼을 클릭해주세요.\n * +1을 누르면 값이 증가됩니다.\n * -1을 누르면 값이 감소됩니다.")
                        Row(
                            modifier = Modifier.align(Alignment.End)
                        ) {
                            Button(onClick = {
                                openDialog = false
                            }) {
                                Text(text = "취소")
                            }
                            Button(onClick = {
                                openDialog = false
                                counter++
                            }) {
                                Text(text = "+1")
                            }
                            Button(onClick = {
                                openDialog = false
                                counter--
                            }) {
                                Text(text = "-1")
                            }
                        }
                    }
                }
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