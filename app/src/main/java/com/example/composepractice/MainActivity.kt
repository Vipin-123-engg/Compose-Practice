package com.example.composepractice

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.getSelectedText
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractice.repository.DataSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            Counter()
        }
    }
}

@Composable
fun Counter() {
    val count = remember {
        mutableIntStateOf(0)
    }

    val isTrue = count.intValue % 3 == 0

    LaunchedEffect(key1 = isTrue) {
        Log.d("Count is: ", "${count.intValue}")
    }


    Button(onClick = { count.intValue++ }) {
        Text(text = "Increament Value", color = Color.White)
    }

}

@Composable
fun Greeting() {
    Text(
        text = "Hello Dear!",
        modifier = Modifier.padding()
    )
}

@Preview(showBackground = true, widthDp = 300, heightDp = 300)
@Composable
fun SampleRow() {
    Column {
        //CreateAppBar()
        CreateTextField()
        //CreateButton()
        TableHeader()
    }

}

@Composable
fun CreateTextField() {
    val context = LocalContext.current
    var text by remember {
        mutableStateOf("")
    }
    TextField(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        placeholder = { Text(text = "Enter Name") },
        label = { Text(text = "Enter Name") },
        value = text,
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = { newText ->
            text = newText
            //showToast(context,text)
        })
}

@Composable
fun CreateButton() {
    val context = LocalContext.current
    Button(border = BorderStroke(1.dp, Color.Red),
        modifier = Modifier.padding(10.dp),
        contentPadding = PaddingValues(20.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
        onClick = { showToast(context, "Hello Dear") }) {
        Image(
            painter = painterResource(R.drawable.baseline_add_shopping_cart_24),
            contentDescription = "",
            modifier = Modifier.size(20.dp)
        )
        Text(text = "Click Me ", color = Color.White)
        Text(text = "Click Me", color = Color.Red)
    }
}

private fun showToast(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateAppBar() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "My Application",
                    )
                },
            )
        },
    ) { innerPadding ->
        Text(
            "Click the back button to pop from the back stack.",
            modifier = Modifier.padding(innerPadding),
        )
    }
}

@Composable
private fun TableHeader() {
    Row(modifier = Modifier.padding(10.dp)) {
        TableCell("Vivek", 3f)
        TableCell("Vipin", 3f)
        TableCell("Vinay", 3f)
    }
}

@Composable
fun RowScope.TableCell(name: String, weight: Float) {
    Text(
        text = name,
        Modifier
            .border(1.dp, Color.Black)
            .weight(weight)
            .padding(8.dp)
    )

}

@Composable
private fun ReusableText() {
    Text(
        text = "Hello Dear!",
        modifier = Modifier.padding(10.dp, 10.dp)
    )
    /*Text(
        text = "Hello Dear!",
        modifier = Modifier.padding(10.dp, 10.dp)
    )
    Text(
        text = "Hello Dear!",
        modifier = Modifier.padding(10.dp, 10.dp)
    )*/
}

/*
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposePracticeTheme {
        Greeting("Android")
    }
}*/
