package com.example.jatpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.height
import com.example.jatpack.ui.theme.JatpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JatpackTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MonArticle(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MonArticle(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.bg_compose_background),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Jetpack Compose tutorial",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "Jetpack Compose is a modern toolkit for building native Android UI. Compose\n" +
                    "simplifies and accelerates UI development on Android with less code,\n" +
                    "powerful tools, and intuitive Kotlin APIs.",
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = "In this tutorial, you build a simple UI component with declarative functions.\n" +
                    "You call Compose functions to say what elements you want and the Compose\n" +
                    "compiler does the rest. Compose is built around Composable functions. These\n" +
                    "functions let you define your app's UI programmatically because they let you\n" +
                    "describe how it should look and provide data dependencies, rather than focus\n" +
                    "on the process of the UI's construction, such as initializing an element and\n" +
                    "then attaching it to a parent. To create a Composable function, you add the\n" +
                    "@Composable annotation to the function name",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MonArticlePreview() {
    JatpackTheme {
        MonArticle()
    }
}