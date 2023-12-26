package com.example.composestudy

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
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
                    TopLevel()
                }
            }
        }
    }
}

class ToDoViewModel : ViewModel() {
    val text = mutableStateOf("")
    val toDoList = mutableStateListOf<ToDoData>()

    val onSubmit: (String) -> Unit = {
        val key = (toDoList.lastOrNull()?.key ?: 0) + 1
        toDoList.add(ToDoData(key, text.value))
        text.value = ""
    }

    val onToggle: (Int, Boolean) -> Unit = { key, checked ->
        val i = toDoList.indexOfFirst { it.key == key }
        // MutableStateList가 추가, 삭제, 변경되었을 때만 UI가 갱신되므로 Copy를 통해 항목 내부의 값을 바꾸기보다 항목 자체를 바꾸도록 설정
        toDoList[i] = toDoList[i].copy(done = checked)
    }

    val onDelete: (Int) -> Unit = { key ->
        val i = toDoList.indexOfFirst { it.key == key }
        toDoList.removeAt(i)
    }

    val onEdit: (Int, String) -> Unit = { key, text ->
        val i = toDoList.indexOfFirst { it.key == key }
        toDoList[i] = toDoList[i].copy(text = text)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopLevel(viewModel: ToDoViewModel = viewModel()) {
//    val (text, setText) = remember { mutableStateOf("") }
//    val toDoList = remember { mutableStateListOf<ToDoData>() }

//    val onSubmit: (String) -> Unit = {
//        val key = (toDoList.lastOrNull()?.key ?: 0) + 1
//        toDoList.add(ToDoData(key, viewModel.text.value))
//        viewModel.text.value = ""
//    }
//
//    val onToggle: (Int, Boolean) -> Unit = { key, checked ->
//        val i = toDoList.indexOfFirst { it.key == key }
//        // MutableStateList가 추가, 삭제, 변경되었을 때만 UI가 갱신되므로 Copy를 통해 항목 내부의 값을 바꾸기보다 항목 자체를 바꾸도록 설정
//        toDoList[i] = toDoList[i].copy(done = checked)
//    }
//
//    val onDelete: (Int) -> Unit = { key ->
//        val i = toDoList.indexOfFirst { it.key == key }
//        toDoList.removeAt(i)
//    }
//
//    val onEdit: (Int, String) -> Unit = { key, text ->
//        val i = toDoList.indexOfFirst { it.key == key }
//        toDoList[i] = toDoList[i].copy(text = text)
//    }

    // 단계 4: `onSubmit`, `onEdit`, `onToggle`, `onDelete`를
    // 만들어 ToDo에 연결합니다.

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            ToDoInput(
                text = viewModel.text.value,
                onTextChange = {
                    viewModel.text.value = it
                },
                onSubmit = viewModel.onSubmit
            )
            // 단계 3: `LazyColumn`으로 `toDoList`를 표시합시다.
            // `key`를 `toDoData`의 `key`를 사용합니다.

            LazyColumn {
                items(
                    viewModel.toDoList,
                    key = {
                        it.key
                    }
                ) { toDoData ->
                    ToDo(
                        toDoData = toDoData,
                        onEdit = viewModel.onEdit,
                        onToggle = viewModel.onToggle,
                        onDelete = viewModel.onDelete
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStudyTheme {
        TopLevel()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoInput(
    text: String,
    onTextChange: (String) -> Unit,
    onSubmit: (String) -> Unit
) {
    val context = LocalContext.current

    Row(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier.weight(1f),
            colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color.Black)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = {
            if (text.isNullOrEmpty()) {
                Toast.makeText(context, "텍스트를 입력하세요.", Toast.LENGTH_SHORT).show()
                return@Button
            }
            onSubmit(text)
        }) {
            Text("입력")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoInputPreview() {
    ComposeStudyTheme {
        ToDoInput("테스트", {}, {})
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDo(
    toDoData: ToDoData,
    onEdit: (key: Int, text: String) -> Unit = { _, _ -> },
    onToggle: (key: Int, checked: Boolean) -> Unit = { _, _ -> },
    onDelete: (key: Int) -> Unit = {}
) {
    var isEditing by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.padding(4.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {

        // 단계 1: `Row`를 만들고 `toDoData.text`를 출력하고
        // 완료를 체크하는 체크박스, 수정 버튼, 삭제 버튼을 만드세요.

        // 단계 2: `Crossfade`를 통해 `isEditing`을 따라 다른
        // UI를 보여줍니다. `OutlinedTextField`와 `Button을
        // 넣어봅시다.
        Crossfade(targetState = isEditing, label = "편집상태 혹은 보기상태") {
            when (it) {
                false -> {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(
                            text = toDoData.text,
                            modifier = Modifier.weight(1f)
                        )
                        Text(text = "완료")

                        Checkbox(
                            checked = toDoData.done,
                            onCheckedChange = { checked ->
                                onToggle(toDoData.key, checked)
                            }
                        )

                        Button(onClick = {
                            isEditing = true
                        }) {
                            Text(text = "수정")
                        }

                        Spacer(modifier = Modifier.size(4.dp))

                        Button(onClick = {
                            onDelete(toDoData.key)
                        }) {
                            Text(text = "삭제")
                        }
                    }
                }

                true -> {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        var newText by remember { mutableStateOf(toDoData.text) }

                        OutlinedTextField(
                            value = newText,
                            onValueChange = {
                                newText = it
                            },
                            modifier = Modifier.weight(1f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color.Black)
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Button(onClick = {
                            onEdit(toDoData.key, newText)
                            isEditing = false
                        }) {
                            Text(text = "완료")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoPreview() {
    ComposeStudyTheme {
        ToDo(ToDoData(1, "nice", true))
    }
}

data class ToDoData(
    val key: Int,
    val text: String,
    val done: Boolean = false
)