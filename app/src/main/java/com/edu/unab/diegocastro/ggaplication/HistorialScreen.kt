package com.edu.unab.diegocastro.ggaplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun HistorialScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFBFFF00)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "HISTORIAL",
                fontSize = 24.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


        Section(title = "HISTORIAL DE ACTIVIDADES TERMINADAS")

        Spacer(modifier = Modifier.height(16.dp))


        ActionButton(text = "MAS")

        Spacer(modifier = Modifier.height(16.dp))


        Section(title = "HISTORIAL DE ACTIVIDADES NO TERMINADAS")

        Spacer(modifier = Modifier.height(16.dp))


        ActionButton(text = "MAS")

        Spacer(modifier = Modifier.height(16.dp))


        ActionButton(text = "SALIR")
    }
}

@Composable
fun Section(title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFBFFF00), RoundedCornerShape(8.dp))
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(8.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(150.dp)
                .background(Color.LightGray, RoundedCornerShape(8.dp))
        )
    }
}

@Composable
fun ActionButton(text: String) {
    Button(
        onClick = {},
        modifier = Modifier
            .width(100.dp)
            .background(Color(0xFFBFFF00), RoundedCornerShape(16.dp))
    ) {
        Text(text = text, color = Color.Black)
    }
}