package com.example.calculator.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FieldScreen(value: String, onValueChange: (String) -> Unit) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        readOnly = true,
        modifier = Modifier
            .background(Color(0xFF2D2D2D)),
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