package com.example.composestudy

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(onButtonClicked = {
                        Toast.makeText(this, "Button Clicked.", Toast.LENGTH_SHORT).show()
                    })
                }
            }
        }
    }
}

@Composable
fun Greeting(onButtonClicked: () -> Unit){
    Button(
        onClick = onButtonClicked,
        enabled = true,
        border = BorderStroke(2.dp, Color.Magenta),
        shape = CircleShape, //RoundedCornerShape(10.dp)
        contentPadding = PaddingValues(20.dp)
    ) {
        Icon(
           imageVector = Icons.Filled.Search,
            contentDescription = null
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "Search")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    ComposeStudyTheme {
        Greeting(onButtonClicked = {})
    }
}