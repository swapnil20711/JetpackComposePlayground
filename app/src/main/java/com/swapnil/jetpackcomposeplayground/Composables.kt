package com.swapnil.jetpackcomposeplayground

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

@Composable
fun GreetingList(namesList: List<String>) {
    Column() {
        for (name in namesList) {
            Greeting(name = name)
        }
    }
}