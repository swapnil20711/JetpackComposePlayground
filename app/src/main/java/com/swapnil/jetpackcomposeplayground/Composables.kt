package com.swapnil.jetpackcomposeplayground

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/*
* Learning states
* */
@Composable
fun WaterCounter() {
    Column(modifier = Modifier.padding(16.dp)) {
        var count = remember { mutableStateOf(0) }
        StateLessCounter(count.value, { count.value++ })
    }
}

@Composable
fun StateLessCounter(count: Int, onIncrement: () -> Int) {
    if (count > 0) {
        Text(text = "You had $count glasses of water")
    }
    OutlinedButton(
        onClick = { onIncrement },
        enabled = count < 10,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Text(text = "Add One")
    }
}