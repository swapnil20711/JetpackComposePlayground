package com.swapnil.jetpackcomposeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

/*val namesList = mutableStateListOf<String>(
    "swap0",
    "kr$",
    "emiway"
)*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaterCounter()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WaterCounter()
}