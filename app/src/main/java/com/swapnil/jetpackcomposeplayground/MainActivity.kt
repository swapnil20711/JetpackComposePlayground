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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*JetpackComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }*/
//            MainScreen()
            RowScreen()
        }
    }
}

@Composable
fun Greeting(name: String) {
    val context = LocalContext.current

    Text(
        text = "Hello $name!",
        Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(16.dp)
            .clickable {
                Toast
                    .makeText(context, "Text clicked", Toast.LENGTH_SHORT)
                    .show()
            },
        style = MaterialTheme.typography.caption,
        color = Color.Green,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun MainScreen() {
    Surface(
        color = Color.LightGray, modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        Surface(
            color = Color.Magenta, modifier = Modifier
                .wrapContentSize(Alignment.TopCenter)
                .padding(8.dp)
        ) {
            Text(
                text = "Wrapped text",
                modifier = Modifier
                    .padding(8.dp),
                style = MaterialTheme.typography.h4
            )
        }
    }
}

@Composable
fun RowScreen() {
    Surface(
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            RowSurfaceWithText(Color.Red, "Android developer")
            RowSurfaceWithText(color = Color.Green, message = "Swapnil Bhojwani")
        }
    }
}

@Composable
fun RowSurfaceWithText(color: Color, message: String) {
    Surface(
        color = color, modifier = Modifier
            .wrapContentSize()
    ) {
        Text(text = message, modifier = Modifier.padding(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
/*    JetpackComposePlaygroundTheme {
        Greeting("Android")
    }*/
//    MainScreen()
    RowScreen()
}