package com.example.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumberRows(numbers: Array<List<Pair<String, () -> Unit>>>, listIndex: Int) {
    LazyRow(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        items(numbers[listIndex].size) { index ->
            val (label, action) = numbers[listIndex][index]
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