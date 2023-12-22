package com.example.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.example.composestudy.ui.theme.ComposeStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStudyTheme {
                Column {
                    Greeting(cardData)
                }
            }
        }
    }

    companion object{
        val cardData = CardData(
            imageUri = "https://raw.githubusercontent.com/roswkzm/ComposeStudy/32c8095f80aae234ed5190102e2091a9d18190e0/app/src/main/res/drawable/wall.jpg",
            imageDescription = "캐년",
            author = "Dalinaum",
            description = "으아으아으아으아으아으아으ㅏ으아으아으아으ㅏ"
        )
    }
}

@Composable
fun Greeting(cardData : CardData) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        modifier = Modifier.padding(4.dp)
    ) {
        ConstraintLayout(modifier = Modifier
            .fillMaxWidth()) {
            val (profileImage, author, description) = createRefs()

            AsyncImage(
                model = cardData.imageUri,
                contentDescription = cardData.imageDescription,
                contentScale = ContentScale.Crop,
                placeholder = ColorPainter(Color.Black),
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .constrainAs(profileImage) {
                        centerVerticallyTo(parent)
                        start.linkTo(parent.start, margin = 8.dp)
                    }
            )

            Text(
                text = cardData.author,
                modifier = Modifier.constrainAs(author) {
                    linkTo(
                        profileImage.end,
                        parent.end,
                        startMargin = 8.dp,
                        endMargin = 8.dp
                    )
                    width = Dimension.fillToConstraints
                }
            )

            Text(
                text = cardData.description,
                modifier = Modifier.constrainAs(description){
                    linkTo(
                        profileImage.end,
                        parent.end,
                        startMargin = 8.dp,
                        endMargin = 8.dp
                    )
                    width = Dimension.fillToConstraints
                }
            )

            val chain = createVerticalChain(
                author,
                description,
                chainStyle = ChainStyle.Packed
            )

            constrain(chain){
                top.linkTo(parent.top, margin = 8.dp)
                bottom.linkTo(parent.bottom, margin = 8.dp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStudyTheme {
        Column {
            Greeting(MainActivity.cardData)
            Greeting(MainActivity.cardData)
            Greeting(MainActivity.cardData)
            Greeting(MainActivity.cardData)
        }
    }
}

data class CardData(
    val imageUri: String,
    val imageDescription: String,
    val author: String,
    val description: String
)