package com.swapnil.jetpackcomposeplayground

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.swapnil.jetpackcomposeplayground.ui.theme.JetpackComposePlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val context = LocalContext.current

    Text(text = "Hello $name!",
        Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(16.dp)
            .clickable {
                Toast
                    .makeText(context, "Text clicked", Toast.LENGTH_SHORT)
                    .show()
            },style = TextStyle(color = Color.Green, fontSize = 24.sp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposePlaygroundTheme {
        Greeting("Android")
    }
}