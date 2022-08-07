package com.swapnil.jetpackcomposeplayground

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage

/*
* Learning states
* */
@Composable
fun WaterCounter() {
    Column(modifier = Modifier.padding(16.dp)) {
        var count = remember { mutableStateOf(0) }
        StateLessCounter(count.value) { count.value++ }
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyGridContent() {
    val list = remember { 1..100 }.map {
        it
    }
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.padding(10.dp)
    ) {
        items(list) { item ->
            SubcomposeAsyncImage(
                model = "https://source.unsplash.com/random/300x300?sig=$item",
                modifier = Modifier
                    .clip(CutCornerShape(16.dp))
                    .clipToBounds()
                    .border(10.dp, Color.Black),
                loading = { CircularProgressIndicator(modifier = Modifier.size(200.dp)) },
                contentDescription = null
            )
        }
    }
}

@Composable
fun LazyGridScreenWithAppBar() {
    Scaffold(topBar = { AppBar() }) {
        LazyGridContent()
    }
}

@Composable
fun AppBar() {
    TopAppBar(title = { Text(text = "Grid Application") }, navigationIcon = {
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
        }
    })
}