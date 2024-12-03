package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF2D2D2D)
    ) {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(bottom = 20.dp)
        ) {
            Button(
                onClick = {},
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .width(85.dp)
                    .height(85.dp)
            ) {
                Text(
                    text = "-",
                    fontSize = 40.sp
                )
            }
            Button(
                onClick = {},
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .width(85.dp)
                    .height(85.dp)

            ) {
                Text(
                    text = "÷",
                    fontSize = 40.sp
                )
            }
            Button(
                onClick = {},
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .width(85.dp)
                    .height(85.dp)
            ) {
                Text(
                    text = "×",
                    fontSize = 40.sp
                )
            }
            Button(
                onClick = {},
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .width(85.dp)
                    .height(85.dp)
            ) {
                Text(
                    text = "+",
                    fontSize = 40.sp
                )
            }

        }
    }
}