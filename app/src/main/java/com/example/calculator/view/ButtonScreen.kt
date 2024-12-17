package com.example.calculator.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.NumberRows

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

    var result by remember {
        mutableIntStateOf(0)
    }

    val buttons = listOf(
        "-" to { operator = "-" },
        "÷" to { operator = "÷" },
        "×" to { operator = "×" },
        "+" to { operator = "+" },
    )

    val numbers: Array<List<Pair<String, () -> Unit>>> = arrayOf(
        listOf(
            "←" to {
                firstValue = ""
                secondValue = ""
                operator = ""
            },
            "7" to { if (operator.isEmpty()) firstValue += "7" else secondValue += "7" },
            "8" to { if (operator.isEmpty()) firstValue += "8" else secondValue += "8" },
            "9" to { if (operator.isEmpty()) firstValue += "9" else secondValue += "9" }
        ),
        listOf(
            "=" to {
                when (operator) {
                    "+" -> result = firstValue.toInt() + secondValue.toInt()
                    "×" -> result = firstValue.toInt() * secondValue.toInt()
                    "÷" -> result = firstValue.toInt() / secondValue.toInt()
                    "-" -> result = firstValue.toInt() - secondValue.toInt()
                }
                operator = ""
                secondValue = ""
                firstValue = result.toString()
            },
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

    val res = firstValue + operator + secondValue

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
                value = res,
                onValueChange = { secondValue = it }
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
            NumberRows(
                numbers = numbers,
                listIndex = 0
            )
            NumberRows(
                numbers = numbers,
                listIndex = 1
            )
            NumberRows(
                numbers = numbers,
                listIndex = 2
            )
        }
    }
}