package com.example.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    Greeting(imageDataItems)
                }
            }
        }
    }
}

data class ItemData(
    val imageUri: String,
    val title: String,
    val description: String
)

@Composable
fun Greeting(itemList: List<ItemData>) {
    LazyColumn {
        item {
            Item(itemData = itemList[0])
        }
        items(itemList) {
            Item(itemData = it)
        }
    }
}

@Composable
fun Item(itemData: ItemData) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                model = itemData.imageUri,
                contentDescription = itemData.title,
                placeholder = painterResource(id = R.drawable.wall)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = itemData.title,
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = itemData.description
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStudyTheme {
        Greeting(imageDataItems)
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    ComposeStudyTheme {
        Item(
            ItemData(
                imageUri = "https://github.com/Fastcampus-JetpackCompose-1/part1-chapter3/blob/main/part1-chapter3-18/app/src/main/res/drawable-xhdpi/a1.jpg?raw=true",
                title = "사진 1 입니다.",
                description = "가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하"
            )
        )
    }
}

val imageDataItems = listOf(
    ItemData(
        imageUri = "https://github.com/Fastcampus-JetpackCompose-1/part1-chapter3/blob/main/part1-chapter3-18/app/src/main/res/drawable-xhdpi/a1.jpg?raw=true",
        title = "사진 1 입니다.",
        description = "가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하"
    ),
    ItemData(
        imageUri = "https://github.com/Fastcampus-JetpackCompose-1/part1-chapter3/blob/main/part1-chapter3-18/app/src/main/res/drawable-xhdpi/a2.jpg?raw=true",
        title = "사진 2 입니다.",
        description = "가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하"
    ),
    ItemData(
        imageUri = "https://github.com/Fastcampus-JetpackCompose-1/part1-chapter3/blob/main/part1-chapter3-18/app/src/main/res/drawable-xhdpi/a3.jpg?raw=true",
        title = "사진 3 입니다.",
        description = "가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하"
    ),
    ItemData(
        imageUri = "https://github.com/Fastcampus-JetpackCompose-1/part1-chapter3/blob/main/part1-chapter3-18/app/src/main/res/drawable-xhdpi/a4.jpg?raw=true",
        title = "사진 4 입니다.",
        description = "가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하"
    ),
    ItemData(
        imageUri = "https://github.com/Fastcampus-JetpackCompose-1/part1-chapter3/blob/main/part1-chapter3-18/app/src/main/res/drawable-xhdpi/a5.jpg?raw=true",
        title = "사진 5 입니다.",
        description = "가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하"
    ),
    ItemData(
        imageUri = "https://github.com/Fastcampus-JetpackCompose-1/part1-chapter3/blob/main/part1-chapter3-18/app/src/main/res/drawable-xhdpi/a6.jpg?raw=true",
        title = "사진 6 입니다.",
        description = "가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하"
    ),
    ItemData(
        imageUri = "https://github.com/Fastcampus-JetpackCompose-1/part1-chapter3/blob/main/part1-chapter3-18/app/src/main/res/drawable-xhdpi/a7.jpg?raw=true",
        title = "사진 7 입니다.",
        description = "가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하"
    ),
    ItemData(
        imageUri = "https://github.com/Fastcampus-JetpackCompose-1/part1-chapter3/blob/main/part1-chapter3-18/app/src/main/res/drawable-xhdpi/a8.jpg?raw=true",
        title = "사진 8 입니다.",
        description = "가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하"
    ),
    ItemData(
        imageUri = "https://github.com/Fastcampus-JetpackCompose-1/part1-chapter3/blob/main/part1-chapter3-18/app/src/main/res/drawable-xhdpi/a9.jpg?raw=true",
        title = "사진 9 입니다.",
        description = "가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하가나다라마바사아자차카타ㅠㅏ하"
    )
)