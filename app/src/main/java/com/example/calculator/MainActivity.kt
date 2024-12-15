package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Main(
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Main(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom
    ) {
        ButtonsScreen()
    }
}

@Composable
fun FieldScreen(value: String, onValueChange: (String) -> Unit) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .background(Color(0xFF2D2D2D))
            .padding(top = 400.dp),
        singleLine = true,
        textStyle = TextStyle(
            fontSize = 50.sp,
            textAlign = TextAlign.End,
            color = Color(0xFFDDDDDD)
        ),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                if (value.isEmpty()) {
                    Text(
                        text = "0",
                        style = TextStyle(
                            fontSize = 50.sp,
                            textAlign = TextAlign.End,
                            color = Color.Gray
                        )
                    )
                }
                innerTextField()
            }
        }
    )
}

@Composable
fun ButtonsScreen(modifier: Modifier = Modifier) {
    var operator by remember {
        mutableStateOf("")
    }

    var firstValue by remember {
        mutableStateOf("")
    }

    var secondValue by remember {
        mutableStateOf("")
    }

    val buttons = listOf(
        "-" to { operator = "-" },
        "÷" to { operator = "÷" },
        "×" to { operator = "×" },
        "+" to { operator = "+" },
    )

    val numbers: Array<List<Pair<String, () -> Unit>>> = arrayOf(
        listOf(
            "←" to {},
            "7" to { if (operator.isEmpty()) firstValue += "7" else secondValue += "7" },
            "8" to { if (operator.isEmpty()) firstValue += "8" else secondValue += "8" },
            "9" to { if (operator.isEmpty()) firstValue += "9" else secondValue += "9" }
        ),
        listOf(
            "=" to {},
            "4" to { if (operator.isEmpty()) firstValue += "4" else secondValue += "4" },
            "5" to { if (operator.isEmpty()) firstValue += "5" else secondValue += "5" },
            "6" to { if (operator.isEmpty()) firstValue += "6" else secondValue += "6" }
        ),
        listOf(
            "0" to { if (operator.isEmpty()) firstValue += "0" else secondValue += "0" },
            "1" to { if (operator.isEmpty()) firstValue += "1" else secondValue += "1" },
            "2" to { if (operator.isEmpty()) firstValue += "2" else secondValue += "2" },
            "3" to { if (operator.isEmpty()) firstValue += "3" else secondValue += "3" }
        )
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF2D2D2D)
    ) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 35.dp)
        ) {
            FieldScreen(
                value = firstValue + operator + secondValue,
                onValueChange = { firstValue = it }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                buttons.forEach { (label, action) ->
                    Button(
                        onClick = action,
                        shape = RoundedCornerShape(25),
                        modifier = Modifier
                            .width(85.dp)
                            .height(85.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD9AD26))
                    ) {
                        Text(
                            text = label,
                            fontSize = 40.sp
                        )
                    }
                }
            }
            LazyRow(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                items(numbers[0].size) { index ->
                    val (label, action) = numbers[0][index]
                    Button(
                        onClick = action,
                        shape = RoundedCornerShape(25),
                        modifier = Modifier
                            .width(85.dp)
                            .height(85.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF484848))
                    ) {
                        Text(
                            text = label,
                            fontSize = 40.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                }
            }
            LazyRow(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                items(numbers[1].size) { index ->
                    val (label, action) = numbers[1][index]
                    Button(
                        onClick = action,
                        shape = RoundedCornerShape(25),
                        modifier = Modifier
                            .width(85.dp)
                            .height(85.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF484848))
                    ) {
                        Text(
                            text = label,
                            fontSize = 40.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                }
            }
            LazyRow(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                items(numbers[2].size) { index ->
                    val (label, action) = numbers[2][index]
                    Button(
                        onClick = action,
                        shape = RoundedCornerShape(25),
                        modifier = Modifier
                            .width(85.dp)
                            .height(85.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF484848))
                    ) {
                        Text(
                            text = label,
                            fontSize = 40.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                }
            }
        }
    }
}