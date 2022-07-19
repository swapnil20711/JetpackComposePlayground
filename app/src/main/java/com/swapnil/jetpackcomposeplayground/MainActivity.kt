package com.swapnil.jetpackcomposeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GreetingScreen()
}

@Composable
fun GreetingScreen(viewModel: MainViewModel = MainViewModel()) {
    /*
    * Both states which are declared first are hoisted and used in this screen
    * */
/*    val greetingListState = remember {
        mutableStateListOf<String>(
            "swap0",
            "kr$",
            "emiway"
        )
    }*/
    var newNameState = viewModel.textFieldState.observeAsState("")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        /*State being passed to another composable that is it is being hoisted
        * */
        val context = LocalContext.current
        GreetingList(
//            greetingListState = greetingListState,
            textFieldState = newNameState.value,
            onTextFieldChanged = { newName ->
                viewModel.onTextChanged(newName)
            },
/*            buttonClick = {
                if (newNameState.value.isEmpty()) {
                    Toast.makeText(context, "Please enter a value", Toast.LENGTH_SHORT).show()
                } else {
                    if (greetingListState.contains(newNameState.value.trim())) {
                        Toast.makeText(context, "Value already added", Toast.LENGTH_SHORT).show()
                    } else {
                        greetingListState.add(newNameState.value)
                        newNameState.value = ""
                    }
                }
            }*/
        )
    }
}

@Composable
fun GreetingList(
//    greetingListState: List<String>,
//    buttonClick: () -> Unit,
    textFieldState: String,
    onTextFieldChanged: (newText: String) -> Unit
) {
/*    for (name in greetingListState) {
        Greeting(name = name)
    }*/
    OutlinedTextField(value = textFieldState, onValueChange = {
        onTextFieldChanged(it)
    })
    Button(onClick = {}) {
        Text(text = textFieldState)
    }
}
