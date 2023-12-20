package com.example.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import coil.compose.AsyncImage
import com.example.composestudy.ui.theme.ComposeStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val constraintSet = ConstraintSet {
        val redBox = createRefFor("redBox")
        val magentaBox = createRefFor("magentaBox")
        val greenBox = createRefFor("greenBox")
        val yellowBox = createRefFor("yellowBox")

        constrain(redBox){
            bottom.linkTo(parent.bottom, margin = 8.dp)
            end.linkTo(parent.end, margin = 4.dp)
        }
        constrain(magentaBox){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(greenBox){
            centerTo(parent)
        }
        constrain(yellowBox){
            start.linkTo(magentaBox.end)
            top.linkTo(magentaBox.bottom)
        }
    }

    ConstraintLayout(
        constraintSet = constraintSet,
        modifier = Modifier.fillMaxSize()
    ) {
//        val (redBox, magentaBox, greenBox, yellowBox) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .layoutId("redBox")
//                .constrainAs(redBox) {
//                    bottom.linkTo(parent.bottom, margin = 8.dp)
//                    end.linkTo(parent.end, margin = 4.dp)
//                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .layoutId("magentaBox")
//                .constrainAs(magentaBox) {
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .layoutId("greenBox")
//                .constrainAs(greenBox) {
//                    centerTo(parent)
//                    centerVerticallyTo(parent)
//                    centerHorizontallyTo(parent)
//                }
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .layoutId("yellowBox")
//                .constrainAs(yellowBox) {
//                    start.linkTo(magentaBox.end)
//                    top.linkTo(magentaBox.bottom)
//                }
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