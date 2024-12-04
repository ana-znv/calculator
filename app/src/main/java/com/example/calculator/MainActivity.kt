package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    val buttons = listOf(
        "-" to {},
        "÷" to {},
        "×" to {},
        "+" to {},
    )

    val numbers: Array<IntArray> = arrayOf(
        intArrayOf(7, 8, 9),
        intArrayOf(4, 5, 6),
        intArrayOf(1, 2, 3)
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
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                items(numbers[0].size) { index ->
                    Button(
                        onClick = {  },
                        shape = RoundedCornerShape(25),
                        modifier = Modifier
                            .width(85.dp)
                            .height(85.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD9AD26))
                    ) {
                        Text(
                            text = (index + 1).toString(),
                            fontSize = 40.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                }
            }
        }
    }
}