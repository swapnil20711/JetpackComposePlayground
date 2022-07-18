package com.swapnil.jetpackcomposeplayground

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GreetingList(namesList: SnapshotStateList<String>) {
    val list = remember {
        namesList
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (name in list) {
            Greeting(name = name)
        }
        Button(onClick = {
            list.add("testing")
        }) {
            Text(text = "Add element")
        }
    }
}

/*
* Learning states
* */
@Composable
fun WaterCounter() {
    Column(modifier = Modifier.padding(16.dp)) {
        var count by rememberSaveable { mutableStateOf(0) }
        StateLessCounter(count, { count++ })
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